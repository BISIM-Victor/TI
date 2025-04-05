package com.support.TI.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Usuarios {

    @Id
    private Long id;
    private String usuario;
    @ManyToOne
    private Perfiles perfil;
    private String nomUsuario;
    private String apUsuario;
    private String amUsuario;
    private String extension;
    private String oficina;
    private String secret;
    private Integer estatus;
    private java.sql.Timestamp lastCon;
    private java.sql.Timestamp lastSecretChange;
    private Integer secretChange;
    private Integer secretPolicy;
}