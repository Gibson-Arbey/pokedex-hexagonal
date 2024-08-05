package co.microservicios.pokedex.domain.api;

import java.util.List;

import co.microservicios.pokedex.domain.model.Type;

public interface ITypeServicePort {
    
    Type saveType(Type type);

    List<Type> getAllTypes();

    Type getType(Long typeId);

    void updateType(Type type);

    void deleteType(Long typeId);
}
