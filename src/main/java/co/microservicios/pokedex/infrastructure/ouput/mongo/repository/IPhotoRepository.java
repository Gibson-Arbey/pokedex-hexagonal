package co.microservicios.pokedex.infrastructure.ouput.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.microservicios.pokedex.infrastructure.ouput.mongo.entity.PhotoEntity;

@Repository
public interface IPhotoRepository extends MongoRepository<PhotoEntity, String> {
    
}
