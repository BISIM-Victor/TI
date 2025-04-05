package com.support.TI.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Venta {

    @Id
    private Long ventaid;
    private String estado;
    private String fecha;
    private String folio;
    private String tipoDocumento;
    private Double total;
    @ManyToOne
    private Cliente cliente;
}