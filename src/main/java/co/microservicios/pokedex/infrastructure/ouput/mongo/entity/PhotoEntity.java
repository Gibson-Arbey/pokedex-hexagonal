package co.microservicios.pokedex.infrastructure.ouput.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Document(collection = "photo")
@Data
public class PhotoEntity {
    
    @Id
    private String id;

    private byte[] photo;
}
