package co.microservicios.pokedex.infrastructure.input.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.microservicios.pokedex.aplicacion.dto.PokedexRequest;
import co.microservicios.pokedex.aplicacion.dto.PokedexResponse;
import co.microservicios.pokedex.aplicacion.handler.IPokedexHandler;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pokedex")
@RequiredArgsConstructor
public class PokedexRestController {

    private final IPokedexHandler pokedexHandler;

    @PostMapping("/")
    public ResponseEntity<Void> savePokemonInPokedex(@RequestBody PokedexRequest pokedexRequest) {
        pokedexHandler.savePokemonInPokedex(pokedexRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<PokedexResponse>> getAllPokemonFromPokedex() {
        return ResponseEntity.ok(pokedexHandler.getAllPokemonFromPokedex());
    }

    @GetMapping("/{number}")
    public ResponseEntity<PokedexResponse> getPokemonInPokedex(@PathVariable(name = "number") Long pokemonNumber) {
        return ResponseEntity.ok(pokedexHandler.getPokemonFromPokedex(pokemonNumber));
    }

    @PutMapping("/")
    public ResponseEntity<Void> updatePokemonInPokedex(@RequestBody PokedexRequest pokedexRequest) {
        pokedexHandler.updatePokemonInPokedex(pokedexRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{pokemonNumber}")
    public ResponseEntity<Void> deletePokemonFromPokedex(@PathVariable Long pokemonNumber) {
        pokedexHandler.deletePokemonFromPokedex(pokemonNumber);
        return ResponseEntity.noContent().build();
    }
}
