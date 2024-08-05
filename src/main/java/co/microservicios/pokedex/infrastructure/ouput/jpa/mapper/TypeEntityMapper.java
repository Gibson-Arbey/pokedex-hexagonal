package co.microservicios.pokedex.infrastructure.ouput.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import co.microservicios.pokedex.domain.model.Type;
import co.microservicios.pokedex.infrastructure.ouput.jpa.entity.TypeEntity;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TypeEntityMapper {

    TypeEntity toEntity(Type type);

    Type toType(TypeEntity typeEntity);

    List<Type> toTypeList(List<TypeEntity> typeEntityList);
}
