package com.plataformasespeciales.api_transacciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiTransaccionesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTransaccionesApplication.class, args);
    }

}