package co.microservicios.pokedex.aplicacion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import co.microservicios.pokedex.aplicacion.dto.TypeDto;
import co.microservicios.pokedex.domain.model.Type;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TypeDtoMapper {

    TypeDto toDto(Type type);
}
