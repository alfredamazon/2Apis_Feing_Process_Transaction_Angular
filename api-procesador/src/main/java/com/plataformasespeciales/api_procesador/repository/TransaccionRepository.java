package com.plataformasespeciales.api_procesador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plataformasespeciales.api_procesador.entity.Transaccion;

@Repository
public interface TransaccionRepository
        extends JpaRepository<Transaccion, Long> {

}