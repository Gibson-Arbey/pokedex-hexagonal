package co.microservicios.pokedex.aplicacion.handler;

import java.util.List;

import co.microservicios.pokedex.aplicacion.dto.PokedexRequest;
import co.microservicios.pokedex.aplicacion.dto.PokedexResponse;

public interface IPokedexHandler {

    void savePokemonInPokedex(PokedexRequest pokedexRequest);

    List<PokedexResponse> getAllPokemonFromPokedex();

    PokedexResponse getPokemonFromPokedex(Long pokemonNumber);

    void updatePokemonInPokedex(PokedexRequest pokedexRequest);

    void deletePokemonFromPokedex(Long pokemonNumber);
}
