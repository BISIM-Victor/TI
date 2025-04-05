package com.support.TI.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Producto {
    @Id
    private Long idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private Double precio;

}
