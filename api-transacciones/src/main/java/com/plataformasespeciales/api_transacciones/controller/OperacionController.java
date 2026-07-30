package com.plataformasespeciales.api_transacciones.controller;

import com.plataformasespeciales.api_transacciones.dto.OperacionRequest;
import com.plataformasespeciales.api_transacciones.dto.OperacionResponse;
import com.plataformasespeciales.api_transacciones.service.OperacionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operaciones")
public class OperacionController {

    private final OperacionService service;

    public OperacionController(
            OperacionService service
    ) {
        this.service = service;
    }

    @PostMapping
    public OperacionResponse registrarOperacion(
            @Valid @RequestBody OperacionRequest request
    ) {

        return service.procesarOperacion(request);

    }

}