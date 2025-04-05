package com.support.TI.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Perfiles {
    @Id
    private Long idPerfil;
    private String nombre;
    private String descripcion;
    private String estatus;

}