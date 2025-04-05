package com.support.TI.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Documento {
    @Id
    private Long documentoId;
    private String fechaEmision;
    private String folio;
    private Double iva;
    private Double subtotal;
    private String tipoDocumento;
    private Double total;
    @ManyToOne
    private Venta venta;
}
