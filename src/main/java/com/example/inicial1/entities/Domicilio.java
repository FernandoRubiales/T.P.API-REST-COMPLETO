package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Domicilio extends Base{

    private String calle;
    private int numero;

    @ManyToOne(optional = false) //esta relacion no es opcional, no puede ser nula
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;
}
