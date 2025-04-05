package com.support.TI.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Dispositivo {

    @Id
    private Long dispositivoid;
    private String estado;
    private String numeroSerie;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Producto producto;

}