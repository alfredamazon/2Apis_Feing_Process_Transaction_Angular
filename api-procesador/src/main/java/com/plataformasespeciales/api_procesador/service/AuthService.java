package com.plataformasespeciales.api_procesador.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.plataformasespeciales.api_procesador.entity.Usuario;
import com.plataformasespeciales.api_procesador.repository.UsuarioRepository;


@Service
public class AuthService {


    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;


    public AuthService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public boolean validarLogin(String usuario, String passwordIngresado) {

    System.out.println("Usuario recibido: " + usuario);
    System.out.println("Password recibido: " + passwordIngresado);

    Usuario user = usuarioRepository.findByUsuario(usuario).orElse(null);

    System.out.println("Usuario encontrado: " + user);

    if (user == null) {
        return false;
    }

    System.out.println("Hash BD: " + user.getPassword());

    boolean valido = passwordEncoder.matches(passwordIngresado, user.getPassword());

    System.out.println("Resultado matches: " + valido);

    return valido;
}
}