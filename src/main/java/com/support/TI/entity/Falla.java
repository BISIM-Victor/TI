package com.support.TI.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Falla {

    @Id
    private Long fallaid;
    private String descripcion;
    private String fechaRegistro;
    private String tipoFalla;
    @ManyToOne
    private Dispositivo dispositivo;
}