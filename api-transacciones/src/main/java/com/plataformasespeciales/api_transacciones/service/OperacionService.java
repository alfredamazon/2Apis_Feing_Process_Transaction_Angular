package com.plataformasespeciales.api_transacciones.service;

import com.plataformasespeciales.api_transacciones.config.AESUtil;
import com.plataformasespeciales.api_transacciones.dto.OperacionRequest;
import com.plataformasespeciales.api_transacciones.dto.OperacionResponse;
import com.plataformasespeciales.api_transacciones.feign.Api2FeignClient;
import org.springframework.stereotype.Service;

@Service
public class OperacionService {

    private final Api2FeignClient feignClient;

    public OperacionService(Api2FeignClient feignClient) {
        this.feignClient = feignClient;
    }

    public OperacionResponse procesarOperacion(
            OperacionRequest request
    ) {

        String secretoPlano =
                AESUtil.decrypt(request.getSecreto());

        request.setSecreto(secretoPlano);

        return feignClient.guardarOperacion(request);

    }

}