package co.microservicios.pokedex.domain.usecase;

import java.util.List;

import co.microservicios.pokedex.domain.api.ITypeServicePort;
import co.microservicios.pokedex.domain.model.Type;
import co.microservicios.pokedex.domain.spi.ITypePersistencePort;

public class TypeUseCase implements ITypeServicePort {

    private final ITypePersistencePort typePersistencePort;

    public TypeUseCase(ITypePersistencePort typePersistencePort) {
        this.typePersistencePort = typePersistencePort;
    }

    @Override
    public Type saveType(Type type) {
        return typePersistencePort.saveType(type);
    }

    @Override
    public List<Type> getAllTypes() {
        return typePersistencePort.getAllTypes();
    }

    @Override
    public Type getType(Long typeId) {
        return typePersistencePort.getType(typeId);
    }

    @Override
    public void updateType(Type type) {
        typePersistencePort.updateType(type);
    }

    @Override
    public void deleteType(Long typeId) {
        typePersistencePort.deleteType(typeId);
    }
    
}
