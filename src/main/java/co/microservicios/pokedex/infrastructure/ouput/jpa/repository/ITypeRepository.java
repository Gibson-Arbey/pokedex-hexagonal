package co.microservicios.pokedex.infrastructure.ouput.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.microservicios.pokedex.infrastructure.ouput.jpa.entity.TypeEntity;

@Repository
public interface ITypeRepository extends JpaRepository<TypeEntity, Long> {
    
}
