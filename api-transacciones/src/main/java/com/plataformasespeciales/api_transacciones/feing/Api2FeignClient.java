package com.plataformasespeciales.api_transacciones.feign;

import com.plataformasespeciales.api_transacciones.dto.OperacionRequest;
import com.plataformasespeciales.api_transacciones.dto.OperacionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "api-procesador",
        url = "http://localhost:8081"
)
public interface Api2FeignClient {

    @PostMapping("/transacciones")
    OperacionResponse guardarOperacion(
            @RequestBody OperacionRequest request
    );

}