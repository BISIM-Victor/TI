package com.support.TI.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class DetalleVenta {

    @Id
    private Long detalleVentaid;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
    @ManyToOne
    private Producto producto;
    @ManyToOne
    private Venta venta;
}