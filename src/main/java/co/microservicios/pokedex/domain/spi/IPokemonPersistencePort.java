package co.microservicios.pokedex.domain.spi;

import java.util.List;

import co.microservicios.pokedex.domain.model.Pokemon;

public interface IPokemonPersistencePort {
    
    void savePokemon(Pokemon pokemon);

    List<Pokemon> getAllPokemon();

    Pokemon getPokemon(Long pokemonNumber);

    void updatePokemon(Pokemon pokemon);

    void deletePokemon(Long pokemonNumber);
}
