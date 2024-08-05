package co.microservicios.pokedex.aplicacion.handler;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.microservicios.pokedex.aplicacion.dto.PokedexRequest;
import co.microservicios.pokedex.aplicacion.dto.PokedexResponse;
import co.microservicios.pokedex.aplicacion.mapper.PokedexRequestMapper;
import co.microservicios.pokedex.aplicacion.mapper.PokedexResponseMapper;
import co.microservicios.pokedex.aplicacion.mapper.TypeDtoMapper;
import co.microservicios.pokedex.domain.api.IPhotoServicePort;
import co.microservicios.pokedex.domain.api.IPokemonServicePort;
import co.microservicios.pokedex.domain.api.ITypeServicePort;
import co.microservicios.pokedex.domain.model.Photo;
import co.microservicios.pokedex.domain.model.Pokemon;
import co.microservicios.pokedex.domain.model.Type;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PokedexHandler implements IPokedexHandler {

    private final IPokemonServicePort pokemonServicePort;
    private final ITypeServicePort typeServicePort;
    private final IPhotoServicePort photoServicePort;
    private final PokedexRequestMapper pokedexRequestMapper;
    private final PokedexResponseMapper pokedexResponseMapper;
    private final TypeDtoMapper typeDtoMapper;

    @Override
    public void savePokemonInPokedex(PokedexRequest pokedexRequest) {
        Type type = typeServicePort.saveType(pokedexRequestMapper.toType(pokedexRequest));
        Photo photo = photoServicePort.savePhoto(pokedexRequestMapper.toPhoto(pokedexRequest));
        Pokemon pokemon = pokedexRequestMapper.toPokemon(pokedexRequest);
        pokemon.setTypeId(type.getId());
        pokemon.setPhotoId(photo.getId());
        pokemonServicePort.savePokemon(pokemon);
    }

    @Override
    public List<PokedexResponse> getAllPokemonFromPokedex() {
        return pokedexResponseMapper.toResponseList(pokemonServicePort.getAllPokemon(), typeServicePort.getAllTypes(), photoServicePort.getAllPhotos());
    }

    @Override
    public PokedexResponse getPokemonFromPokedex(Long pokemonNumber) {
        Pokemon pokemon = pokemonServicePort.getPokemon(pokemonNumber);
        return pokedexResponseMapper.toResponse(pokemon, typeDtoMapper.toDto(typeServicePort.getType(pokemon.getTypeId())), photoServicePort.getPhoto(pokemon.getPhotoId()));
    }

    @Override
    public void updatePokemonInPokedex(PokedexRequest pokedexRequest) {
        Pokemon oldPokemon = pokemonServicePort.getPokemon(pokedexRequest.getNumber());
        Type newType = pokedexRequestMapper.toType(pokedexRequest);
        newType.setId(oldPokemon.getTypeId());
        typeServicePort.updateType(newType);
        Photo newPhoto = pokedexRequestMapper.toPhoto(pokedexRequest);
        newPhoto.setId(oldPokemon.getPhotoId());
        photoServicePort.updatePhoto(newPhoto);
        Pokemon newPokemon = pokedexRequestMapper.toPokemon(pokedexRequest);
        newPokemon.setId(oldPokemon.getId());
        newPokemon.setTypeId(oldPokemon.getTypeId());
        newPokemon.setPhotoId(oldPokemon.getPhotoId());
        pokemonServicePort.updatePokemon(newPokemon);
    }

    @Override
    public void deletePokemonFromPokedex(Long pokemonNumber) {
        Pokemon pokemon = pokemonServicePort.getPokemon(pokemonNumber);
        typeServicePort.deleteType(pokemon.getTypeId());
        photoServicePort.deletePhoto(pokemon.getPhotoId());
        pokemonServicePort.deletePokemon(pokemonNumber);
    }

}
