package co.microservicios.pokedex.domain.usecase;

import java.util.List;

import co.microservicios.pokedex.domain.api.IPokemonServicePort;
import co.microservicios.pokedex.domain.model.Pokemon;
import co.microservicios.pokedex.domain.spi.IPokemonPersistencePort;

public class PokemonUseCase implements IPokemonServicePort{

    private final IPokemonPersistencePort pokemonPersistencePort;

    public PokemonUseCase(IPokemonPersistencePort pokemonPersistencePort) {
        this.pokemonPersistencePort = pokemonPersistencePort;
    }

    @Override
    public void savePokemon(Pokemon pokemon) {
        pokemonPersistencePort.savePokemon(pokemon);
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonPersistencePort.getAllPokemon();
    }

    @Override
    public Pokemon getPokemon(Long pokemonNumber) {
        return pokemonPersistencePort.getPokemon(pokemonNumber);
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {
        pokemonPersistencePort.updatePokemon(pokemon);
    }

    @Override
    public void deletePokemon(Long pokemonNumber) {
        pokemonPersistencePort.deletePokemon(pokemonNumber);
    }
    
}
