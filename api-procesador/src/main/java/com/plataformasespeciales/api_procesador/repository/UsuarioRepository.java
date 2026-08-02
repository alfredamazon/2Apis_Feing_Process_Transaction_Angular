package com.plataformasespeciales.api_procesador.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plataformasespeciales.api_procesador.entity.Usuario;


@Repository
public interface UsuarioRepository 
        extends JpaRepository<Usuario, Long> {


    Optional<Usuario> findByUsuario(String usuario);

}