package com.support.TI.repository;

import com.support.TI.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    @Query("SELECT u FROM Usuarios u WHERE u.estatus = :estatus")
    List<Usuarios> findByEstatus(@Param("estatus") Integer estatus);

}

