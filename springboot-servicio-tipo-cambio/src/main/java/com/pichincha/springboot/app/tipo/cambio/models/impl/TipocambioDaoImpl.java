package com.pichincha.springboot.app.tipo.cambio.models.impl;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;
import com.pichincha.springboot.app.tipo.cambio.models.dao.TipocambioDao;
import com.pichincha.springboot.app.tipo.cambio.models.dto.RequestCalculateDTO;
import com.pichincha.springboot.app.tipo.cambio.models.dto.ResponseCalculateDTO;
import com.pichincha.springboot.app.tipo.cambio.models.dto.TipocambioDTO;
import com.pichincha.springboot.app.tipo.cambio.models.entity.Tipocambio;
import com.pichincha.springboot.app.tipo.cambio.models.service.TipocambioService;
import com.pichincha.springboot.app.tipo.cambio.models.service.TipocambioServiceProccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TipocambioDaoImpl implements TipocambioServiceProccess {

    @Autowired
    @Qualifier("serviceFeign")
    private TipocambioService itemService;

    @Autowired
    private TipocambioDao tipocambioDao;
    public List<TipocambioDTO> listar() {
        List<Tipocambio> listaTiposCambio = (List<Tipocambio>) tipocambioDao.findAll();
        List<TipocambioDTO> TipocambioDTOList= new ArrayList<>();
        for (Tipocambio tipoCambio : listaTiposCambio) {
            TipocambioDTO tipeNew= new TipocambioDTO();
            tipeNew.setId(tipoCambio.getId());
            tipeNew.setMonedaOrigen(tipoCambio.getMonedaOrigen());
            tipeNew.setMonedaDestino(tipoCambio.getMonedaDestino());
            tipeNew.setNombreOrigen(tipoCambio.getNombreOrigen());
            tipeNew.setNombreDestino(tipoCambio.getNombreDestino());
            tipeNew.setPrecio(tipoCambio.getPrecio());
            tipeNew.setCreateAt(tipoCambio.getCreateAt().toString());
            Usuario usu=itemService.findById(tipoCambio.getCreateUser());
            usu.setPassword(null);
            usu.setUsername(null);
            tipeNew.setCreateUser(usu);
            TipocambioDTOList.add(tipeNew);
        }
        return TipocambioDTOList;
    }
    public TipocambioDTO get(Long id) {
        Optional<Tipocambio> optionaltipoCambio=tipocambioDao.findById(id);
            TipocambioDTO tipeNew= new TipocambioDTO();
        if (optionaltipoCambio.isPresent()) {
            Tipocambio tipoCambio = optionaltipoCambio.get();
            tipeNew.setId(tipoCambio.getId());
            tipeNew.setMonedaDestino(tipoCambio.getMonedaDestino());
            tipeNew.setMonedaOrigen(tipoCambio.getMonedaOrigen());
            tipeNew.setPrecio(tipoCambio.getPrecio());
            tipeNew.setNombreOrigen(tipoCambio.getNombreOrigen());
            tipeNew.setNombreDestino(tipoCambio.getNombreDestino());
            tipeNew.setCreateAt(tipoCambio.getCreateAt().toString());
            Usuario usu=itemService.findById(tipoCambio.getCreateUser());
            usu.setPassword(null);
            usu.setUsername(null);
            tipeNew.setCreateUser(usu);
        }
        return tipeNew;
    }

    public ResponseCalculateDTO calculate (RequestCalculateDTO requestCalculate){
        Optional<Tipocambio> optionaltipoCambio= Optional.ofNullable(tipocambioDao.obtenerPorMonedaOrigenMonedaDestino(requestCalculate.getMonedaOrigen(), requestCalculate.getMonedaDestino()));
        if(optionaltipoCambio.isPresent()){
            Tipocambio tipocambio=optionaltipoCambio.get();
            Double total=tipocambio.getPrecio()*requestCalculate.getMonto();
            ResponseCalculateDTO responseCalculateDTO=new ResponseCalculateDTO();
            responseCalculateDTO.setMonedaDestino(tipocambio.getMonedaDestino());
            responseCalculateDTO.setMonedaOrigen(tipocambio.getMonedaOrigen());
            responseCalculateDTO.setNombreOrigen(tipocambio.getNombreOrigen());
            responseCalculateDTO.setNombreDestino(tipocambio.getNombreDestino());
            responseCalculateDTO.setMonto(requestCalculate.getMonto());
            responseCalculateDTO.setTotal(total);
            return responseCalculateDTO;
        }else{
            throw new ResourceNotFoundException("Tipo de cambio no registrado");
        }

    }


}
