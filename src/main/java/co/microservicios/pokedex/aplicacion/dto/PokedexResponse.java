package co.microservicios.pokedex.aplicacion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokedexResponse {
    
    private Long number;
    private String name;
    private TypeDto types;
    private String photo;
}
