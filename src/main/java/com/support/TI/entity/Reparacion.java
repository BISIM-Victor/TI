package com.support.TI.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Reparacion {

    @Id
    private Long reparacionid;
    private Double costo;
    private String estado;
    private String fechaFin;
    private String fechaInicio;
    @ManyToOne
    private Falla falla;
}