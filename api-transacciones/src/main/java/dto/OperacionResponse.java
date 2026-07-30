package com.plataformasespeciales.api_transacciones.dto;

import lombok.Data;

@Data
public class OperacionResponse {

    private Long id;

    private String estatus;

    private String referencia;

    private String operacion;

}