package com.support.TI.service;

import com.support.TI.Enums.MessageEnum;
import com.support.TI.dto.ResponseDTO;
import com.support.TI.entity.Usuarios;
import com.support.TI.repository.UsuariosRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
    private static final Logger logger = LogManager.getLogger(UsuariosService.class);

    @Autowired
    private UsuariosRepository usuariosRepository;

    // Método para crear un usuario
    public ResponseDTO createUsuarios(Usuarios usuario) {
        ResponseDTO response = new ResponseDTO();
        try {
            Usuarios usuarios = usuariosRepository.save(usuario);
            logger.info("Usuario creado: {}", usuarios);
            response.setMsg(MessageEnum.OK.getMessage());
            response.setBody(usuarios);
        } catch (Exception e) {
            logger.error("Error al crear usuario", e);
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }
        return response;
    }

    // Obtener todos los usuarios
    public ResponseDTO getAllUsuarios() {
        ResponseDTO response = new ResponseDTO();
        try {
            List<Usuarios> usuarios = usuariosRepository.findAll();
            response.setMsg(MessageEnum.OK.getMessage());
            response.setBody(usuarios);
        } catch (Exception e) {
            logger.error("Error al obtener los usuarios", e);
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }
        return response;
    }

    // Obtener un usuario por ID
    public ResponseDTO getUsuarios(Long id) {
        ResponseDTO response = new ResponseDTO();
        try {
            Optional<Usuarios> usuarios = usuariosRepository.findById(id);
            if (usuarios.isPresent()) {
                response.setMsg(MessageEnum.OK.getMessage());
                response.setBody(usuarios.get());
            } else {
                response.setMsg(MessageEnum.NOT_FOUND.getMessage());
                response.setBody(null);
            }
        } catch (Exception e) {
            logger.error("Error al obtener usuario", e);
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }
        return response;
    }

    // Obtener usuarios activos
    public ResponseDTO getUsuariosActivos() {
        ResponseDTO response = new ResponseDTO();
        try {
            List<Usuarios> usuariosActivos = usuariosRepository.findByEstatus(1);
            response.setMsg(MessageEnum.OK.getMessage());
            response.setBody(usuariosActivos);
        } catch (Exception e) {
            logger.error("Error al obtener usuarios activos", e);
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }
        return response;
    }

    // Eliminar usuario (borrado lógico)
    public ResponseDTO deleteUsuarios(Long id) {
        ResponseDTO response = new ResponseDTO();
        try {
            Optional<Usuarios> usuarios = usuariosRepository.findById(id);
            if (usuarios.isPresent()) {
                Usuarios usuario = usuarios.get();
                if (usuario.getEstatus() != 0) {
                    usuario.setEstatus(0);
                    usuariosRepository.save(usuario);
                    response.setMsg(MessageEnum.OK.getMessage());
                } else {
                    response.setMsg("El usuario ya está eliminado");
                }
            } else {
                response.setMsg("Usuario no encontrado");
            }
            response.setBody(null);
        } catch (Exception e) {
            logger.error("Error al eliminar usuario", e);
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }
        return response;
    }
}
