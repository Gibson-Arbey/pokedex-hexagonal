package co.microservicios.pokedex.infrastructure.ouput.jpa.adapter;

import java.util.List;

import co.microservicios.pokedex.domain.model.Pokemon;
import co.microservicios.pokedex.domain.spi.IPokemonPersistencePort;
import co.microservicios.pokedex.infrastructure.exception.NoDataFoundException;
import co.microservicios.pokedex.infrastructure.exception.PokemonAlreadyExistsException;
import co.microservicios.pokedex.infrastructure.exception.PokemonNotFoundException;
import co.microservicios.pokedex.infrastructure.ouput.jpa.entity.PokemonEntity;
import co.microservicios.pokedex.infrastructure.ouput.jpa.mapper.PokemonEntityMapper;
import co.microservicios.pokedex.infrastructure.ouput.jpa.repository.IPokemonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PokemonJpaAdapter implements IPokemonPersistencePort{
    
    private final IPokemonRepository pokemonRepository;

    private final PokemonEntityMapper pokemonEntityMapper;

    @Override
    public void savePokemon(Pokemon pokemon) {
        if(pokemonRepository.findByNumber(pokemon.getNumber()).isPresent()) {
            throw new PokemonAlreadyExistsException();
        }
        pokemonRepository.save(pokemonEntityMapper.toEntity(pokemon));
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        List<PokemonEntity> pokemonEntityList = pokemonRepository.findAll();
        if(pokemonEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return pokemonEntityMapper.toPokemonList(pokemonEntityList);
    }

    @Override
    public Pokemon getPokemon(Long pokemonNumber) {
        return pokemonEntityMapper.toPokemon(pokemonRepository.findByNumber(pokemonNumber).orElseThrow(PokemonNotFoundException::new));
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemonEntityMapper.toEntity(pokemon));
    }

    @Override
    public void deletePokemon(Long pokemonNumber) {
        pokemonRepository.deleteByNumber(pokemonNumber);
    }
}
