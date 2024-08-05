package co.microservicios.pokedex.domain.api;

import java.util.List;

import co.microservicios.pokedex.domain.model.Pokemon;

public interface IPokemonServicePort {
    
    void savePokemon(Pokemon pokemon);

    List<Pokemon> getAllPokemon();

    Pokemon getPokemon(Long pokemonNumber);

    void updatePokemon(Pokemon pokemon);

    void deletePokemon(Long pokemonNumber);
}
