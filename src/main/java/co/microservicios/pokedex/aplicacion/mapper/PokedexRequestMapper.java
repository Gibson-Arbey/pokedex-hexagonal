package co.microservicios.pokedex.aplicacion.mapper;

import java.util.Base64;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import co.microservicios.pokedex.aplicacion.dto.PokedexRequest;
import co.microservicios.pokedex.domain.model.Photo;
import co.microservicios.pokedex.domain.model.Pokemon;
import co.microservicios.pokedex.domain.model.Type;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PokedexRequestMapper {

    Pokemon toPokemon(PokedexRequest pokedexRequest);

    @Mapping(source = "pokedexRequest.types.firstType", target = "firstType")
    @Mapping(source = "pokedexRequest.types.secondType", target = "secondType")
    Type toType(PokedexRequest pokedexRequest);

    @Mapping(target = "photo", qualifiedByName = "base64ToByteArray")
    Photo toPhoto(PokedexRequest pokedexRequest);

    @Named("base64ToByteArray")
    static byte[] base64ToByteArray(String base64Photo) {
        return Base64.getDecoder().decode(base64Photo);
    }
}
