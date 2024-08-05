package co.microservicios.pokedex.domain.usecase;

import java.util.List;

import co.microservicios.pokedex.domain.api.IPhotoServicePort;
import co.microservicios.pokedex.domain.model.Photo;
import co.microservicios.pokedex.domain.spi.IPhotoPersistencePort;

public class PhotoUseCase implements IPhotoServicePort {

    private final IPhotoPersistencePort photoPersistencePort;

    public PhotoUseCase(IPhotoPersistencePort photoPersistencePort) {
        this.photoPersistencePort = photoPersistencePort;
    }

    @Override
    public Photo savePhoto(Photo photo) {
        return photoPersistencePort.savePhoto(photo);
    }

    @Override
    public List<Photo> getAllPhotos() {
        return photoPersistencePort.getAllPhotos();
    }

    @Override
    public Photo getPhoto(String photoId) {
        return photoPersistencePort.getPhoto(photoId);
    }

    @Override
    public void updatePhoto(Photo photo) {
        photoPersistencePort.updatePhoto(photo);
    }

    @Override
    public void deletePhoto(String photoId) {
        photoPersistencePort.deletePhoto(photoId);
    }
    
}
