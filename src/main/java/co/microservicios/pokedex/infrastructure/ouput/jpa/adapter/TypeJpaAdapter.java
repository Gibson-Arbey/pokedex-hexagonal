package co.microservicios.pokedex.infrastructure.ouput.jpa.adapter;

import java.util.List;

import co.microservicios.pokedex.domain.model.Type;
import co.microservicios.pokedex.domain.spi.ITypePersistencePort;
import co.microservicios.pokedex.infrastructure.exception.NoDataFoundException;
import co.microservicios.pokedex.infrastructure.exception.TypeNotFoundException;
import co.microservicios.pokedex.infrastructure.ouput.jpa.entity.TypeEntity;
import co.microservicios.pokedex.infrastructure.ouput.jpa.mapper.TypeEntityMapper;
import co.microservicios.pokedex.infrastructure.ouput.jpa.repository.ITypeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TypeJpaAdapter implements ITypePersistencePort {

    private final ITypeRepository typeRepository;

    private final TypeEntityMapper typeEntityMapper;

    @Override
    public Type saveType(Type type) {
        return typeEntityMapper.toType(typeRepository.save(typeEntityMapper.toEntity(type))); 
    }

    @Override
    public List<Type> getAllTypes() {
        List<TypeEntity> typeEntityList = typeRepository.findAll();
        if(typeEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return typeEntityMapper.toTypeList(typeEntityList);
    }

    @Override
    public Type getType(Long typeId) {
        return typeEntityMapper.toType(typeRepository.findById(typeId).orElseThrow(TypeNotFoundException::new));
    }

    @Override
    public void updateType(Type type) {
        typeRepository.save(typeEntityMapper.toEntity(type));
    }

    @Override
    public void deleteType(Long typeId) {
        typeRepository.deleteById(typeId);
    }

}
