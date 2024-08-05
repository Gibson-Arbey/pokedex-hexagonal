package co.microservicios.pokedex.infrastructure.configuration;

import co.microservicios.pokedex.infrastructure.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class ExceptionConfiguration {

    private static final String MESSAGE = "Message";

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
    }

    @ExceptionHandler(PokemonAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handlePokemonAlreadyExistsException(
            PokemonAlreadyExistsException pokemonAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.POKEMON_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePokemonNotFoundException(
            PokemonNotFoundException pokemonNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.POKEMON_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(TypeNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTypeNotFoundException(
            TypeNotFoundException typeNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.TYPE_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(PhotoNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePhotoNotFoundException(
            PhotoNotFoundException photoNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.PHOTO_NOT_FOUND.getMessage()));
    }
}
