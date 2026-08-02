package com.plataformasespeciales.api_procesador.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.plataformasespeciales.api_procesador.dto.OperacionRequest;
import com.plataformasespeciales.api_procesador.dto.OperacionResponse;
import com.plataformasespeciales.api_procesador.entity.Transaccion;
import com.plataformasespeciales.api_procesador.repository.TransaccionRepository;

@Service
public class TransaccionService {

    private final TransaccionRepository repository;
    
    public TransaccionService(TransaccionRepository repository) {
        this.repository = repository;
    }

    public OperacionResponse guardarOperacion(OperacionRequest request) {
        System.out.println("Antes de guardar...");
        Random random = new Random();

        Integer referencia = 100000 + random.nextInt(900000);

        Transaccion transaccion = new Transaccion();

        transaccion.setOperacion(request.getOperacion());
        transaccion.setImporte(request.getImporte());
        transaccion.setCliente(request.getCliente());
        transaccion.setSecreto(request.getSecreto());
        transaccion.setReferencia(referencia);
        transaccion.setEstatus("Aprobada");

        Transaccion guardada = repository.save(transaccion);

        OperacionResponse response = new OperacionResponse();

        response.setId(guardada.getId());
        response.setOperacion(guardada.getOperacion());
        response.setReferencia(guardada.getReferencia());
        response.setEstatus(guardada.getEstatus());

        return response;

    }

}