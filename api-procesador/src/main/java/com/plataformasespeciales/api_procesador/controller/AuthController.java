package com.plataformasespeciales.api_procesador.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plataformasespeciales.api_procesador.dto.LoginRequest;
import com.plataformasespeciales.api_procesador.dto.LoginResponse;
import com.plataformasespeciales.api_procesador.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        boolean loginCorrecto = authService.validarLogin(
                request.getUsuario(),
                request.getPassword());

        if (loginCorrecto) {
            return ResponseEntity.ok(
                    new LoginResponse("Login correcto"));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new LoginResponse("Usuario o contraseña incorrectos"));
    }



        @GetMapping("/test")
    public String test() {
        return "AUTH OK";
    }
}