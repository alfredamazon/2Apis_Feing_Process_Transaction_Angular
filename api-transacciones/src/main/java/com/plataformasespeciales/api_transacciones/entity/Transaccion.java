package com.plataformasespeciales.api_transacciones.entity;


import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "transacciones")
public class Transaccion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String operacion;


    private BigDecimal importe;


    private String cliente;


    private Integer referencia;


    private String estatus;


    private String secreto;



    public Transaccion() {
    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }



    public String getOperación() {
        return operacion;
    }


    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }



    public BigDecimal getImporte() {
        return importe;
    }


    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }



    public String getCliente() {
        return cliente;
    }


    public void setCliente(String cliente) {
        this.cliente = cliente;
    }



    public Integer getReferencia() {
        return referencia;
    }


    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }



    public String getEstatus() {
        return estatus;
    }


    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }



    public String getSecreto() {
        return secreto;
    }


    public void setSecreto(String secreto) {
        this.secreto = secreto;
    }

}