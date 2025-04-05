package com.support.TI.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class Cliente {
    @Id
    private Long clienteid;
    private String correo;
    private String direccion;
    private String nombre;
    private String telefono;
}
