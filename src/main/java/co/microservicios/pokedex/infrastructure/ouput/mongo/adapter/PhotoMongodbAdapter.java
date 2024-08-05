package co.microservicios.pokedex.infrastructure.ouput.mongo.adapter;

import java.util.List;

import co.microservicios.pokedex.domain.model.Photo;
import co.microservicios.pokedex.domain.spi.IPhotoPersistencePort;
import co.microservicios.pokedex.infrastructure.exception.NoDataFoundException;
import co.microservicios.pokedex.infrastructure.exception.PhotoNotFoundException;
import co.microservicios.pokedex.infrastructure.ouput.mongo.entity.PhotoEntity;
import co.microservicios.pokedex.infrastructure.ouput.mongo.mapper.PhotoEntityMapper;
import co.microservicios.pokedex.infrastructure.ouput.mongo.repository.IPhotoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PhotoMongodbAdapter implements IPhotoPersistencePort {

    private final IPhotoRepository photoRepository;

    private final PhotoEntityMapper photoEntityMapper;

    @Override
    public Photo savePhoto(Photo photo) {
        return photoEntityMapper.toPhoto(photoRepository.save(photoEntityMapper.toEntity(photo)));
    }

    @Override
    public List<Photo> getAllPhotos() {
        List<PhotoEntity> photoEntityList = photoRepository.findAll();
        if(photoEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return photoEntityMapper.toPhotoList(photoEntityList);
    }

    @Override
    public Photo getPhoto(String photoId) {
        return photoEntityMapper.toPhoto(photoRepository.findById(photoId).orElseThrow(PhotoNotFoundException::new));
    }

    @Override
    public void updatePhoto(Photo photo) {
        photoRepository.save(photoEntityMapper.toEntity(photo));
    }

    @Override
    public void deletePhoto(String photoId) {
        photoRepository.deleteById(photoId);
    }
    
}
