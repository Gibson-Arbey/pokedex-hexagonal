package co.microservicios.pokedex.infrastructure.ouput.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.microservicios.pokedex.infrastructure.ouput.jpa.entity.PokemonEntity;

@Repository
public interface IPokemonRepository extends JpaRepository<PokemonEntity, Long> {
    
    Optional<PokemonEntity> findByNumber(Long pokemonNumber);

    void deleteByNumber(Long pokemonNumber);
}
