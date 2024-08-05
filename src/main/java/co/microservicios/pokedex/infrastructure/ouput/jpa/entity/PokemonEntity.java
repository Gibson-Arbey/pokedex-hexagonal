package co.microservicios.pokedex.infrastructure.ouput.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pokemon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    private String name;

    private Long typeId;

    private String photoId;
}
