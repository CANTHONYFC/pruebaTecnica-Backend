package com.pichincha.springboot.app.tipo.cambio.models.dto;
import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;

import javax.persistence.Column;


public class TipocambioDTO {
    private Long id;
    private String monedaOrigen;
    private String monedaDestino;
    private Double precio;
    private String createAt;
    private Usuario createUser;

    private String nombreOrigen;
    private String nombreDestino;

    public String getNombreOrigen() {
        return nombreOrigen;
    }

    public void setNombreOrigen(String nombreOrigen) {
        this.nombreOrigen = nombreOrigen;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public Usuario getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Usuario createUser) {
        this.createUser = createUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }
}
