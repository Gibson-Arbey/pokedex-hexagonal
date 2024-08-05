package co.microservicios.pokedex.aplicacion.dto;

import co.microservicios.pokedex.domain.model.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokedexRequest {
    
    private Long number;

    private String name;

    private Type types;

    private String photo;
}
