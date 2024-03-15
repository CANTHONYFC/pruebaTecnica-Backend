package com.pichincha.springboot.app.tipo.cambio.models.dao;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;
import com.pichincha.springboot.app.tipo.cambio.models.dto.TipocambioDTO;
import com.pichincha.springboot.app.tipo.cambio.models.entity.Tipocambio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TipocambioDao extends CrudRepository<Tipocambio, Long>{
    @Query("select t from Tipocambio t where t.monedaOrigen=?1 and t.monedaDestino=?2")
    public Tipocambio obtenerPorMonedaOrigenMonedaDestino(String monedaOrigen,String monedaDestino);
}
