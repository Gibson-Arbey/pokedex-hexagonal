package co.microservicios.pokedex.infrastructure.ouput.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import co.microservicios.pokedex.domain.model.Pokemon;
import co.microservicios.pokedex.infrastructure.ouput.jpa.entity.PokemonEntity;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PokemonEntityMapper {

    PokemonEntity toEntity(Pokemon pokemon);

    Pokemon toPokemon(PokemonEntity pokemonEntity);

    List<Pokemon> toPokemonList(List<PokemonEntity> pokemonEntityList);
}
