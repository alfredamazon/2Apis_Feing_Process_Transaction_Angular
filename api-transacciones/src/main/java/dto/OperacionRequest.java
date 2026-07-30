package com.plataformasespeciales.api_transacciones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class OperacionRequest {

    @NotBlank(message = "La operación es obligatoria")
    @Pattern(
            regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$",
            message = "La operación solo puede contener letras"
    )
    private String operacion;

    @NotBlank(message = "El importe es obligatorio")
    @Pattern(
            regexp = "^\\d+(\\.\\d{1,2})?$",
            message = "Formato de importe inválido"
    )
    private String importe;

    @NotBlank(message = "El cliente es obligatorio")
    @Pattern(
            regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$",
            message = "El cliente solo puede contener letras"
    )
    private String cliente;

    @NotBlank(message = "El secreto es obligatorio")
    private String secreto;

}