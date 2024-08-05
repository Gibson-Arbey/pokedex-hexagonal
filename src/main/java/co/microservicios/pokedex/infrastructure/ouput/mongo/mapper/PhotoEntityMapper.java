package co.microservicios.pokedex.infrastructure.ouput.mongo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import co.microservicios.pokedex.domain.model.Photo;
import co.microservicios.pokedex.infrastructure.ouput.mongo.entity.PhotoEntity;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoEntityMapper {

    PhotoEntity toEntity(Photo photo);

    Photo toPhoto(PhotoEntity photoEntity);

    List<Photo> toPhotoList(List<PhotoEntity> photoEntityList);
}
