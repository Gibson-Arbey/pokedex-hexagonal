package co.microservicios.pokedex.domain.spi;

import java.util.List;

import co.microservicios.pokedex.domain.model.Photo;

public interface IPhotoPersistencePort {

    Photo savePhoto(Photo photo);

    List<Photo> getAllPhotos();

    Photo getPhoto(String photoId);

    void updatePhoto(Photo photo);

    void deletePhoto(String photoId);
}
