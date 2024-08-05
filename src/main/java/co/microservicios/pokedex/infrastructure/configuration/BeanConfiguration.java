package co.microservicios.pokedex.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.microservicios.pokedex.domain.api.IPhotoServicePort;
import co.microservicios.pokedex.domain.api.IPokemonServicePort;
import co.microservicios.pokedex.domain.api.ITypeServicePort;
import co.microservicios.pokedex.domain.spi.IPhotoPersistencePort;
import co.microservicios.pokedex.domain.spi.IPokemonPersistencePort;
import co.microservicios.pokedex.domain.spi.ITypePersistencePort;
import co.microservicios.pokedex.domain.usecase.PhotoUseCase;
import co.microservicios.pokedex.domain.usecase.PokemonUseCase;
import co.microservicios.pokedex.domain.usecase.TypeUseCase;
import co.microservicios.pokedex.infrastructure.ouput.jpa.adapter.PokemonJpaAdapter;
import co.microservicios.pokedex.infrastructure.ouput.jpa.adapter.TypeJpaAdapter;
import co.microservicios.pokedex.infrastructure.ouput.jpa.mapper.PokemonEntityMapper;
import co.microservicios.pokedex.infrastructure.ouput.jpa.mapper.TypeEntityMapper;
import co.microservicios.pokedex.infrastructure.ouput.jpa.repository.IPokemonRepository;
import co.microservicios.pokedex.infrastructure.ouput.jpa.repository.ITypeRepository;
import co.microservicios.pokedex.infrastructure.ouput.mongo.adapter.PhotoMongodbAdapter;
import co.microservicios.pokedex.infrastructure.ouput.mongo.mapper.PhotoEntityMapper;
import co.microservicios.pokedex.infrastructure.ouput.mongo.repository.IPhotoRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IPokemonRepository pokemonRepository;
    private final PokemonEntityMapper pokemonEntityMapper;
    private final ITypeRepository typeRepository;
    private final TypeEntityMapper typeEntityMapper;
    private final IPhotoRepository photoRepository;
    private final PhotoEntityMapper photoEntityMapper;

    @Bean
    public IPokemonPersistencePort pokemonPersistencePort() {
        return new PokemonJpaAdapter(pokemonRepository, pokemonEntityMapper);
    }

    @Bean
    public IPokemonServicePort pokemonServicePort() {
        return new PokemonUseCase(pokemonPersistencePort());
    }

    @Bean
    public ITypePersistencePort typePersistencePort() {
        return new TypeJpaAdapter(typeRepository, typeEntityMapper);
    }

    @Bean
    public ITypeServicePort typeServicePort() {
        return new TypeUseCase(typePersistencePort());
    }

    @Bean
    public IPhotoPersistencePort photoPersistencePort() {
        return new PhotoMongodbAdapter(photoRepository, photoEntityMapper);
    }

    @Bean
    public IPhotoServicePort photoServicePort() {
        return new PhotoUseCase(photoPersistencePort());
    }
}
