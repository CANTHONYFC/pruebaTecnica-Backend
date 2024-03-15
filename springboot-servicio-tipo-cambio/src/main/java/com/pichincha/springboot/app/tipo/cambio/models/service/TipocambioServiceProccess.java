package com.pichincha.springboot.app.tipo.cambio.models.service;
import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;
import com.pichincha.springboot.app.tipo.cambio.models.dto.RequestCalculateDTO;
import com.pichincha.springboot.app.tipo.cambio.models.dto.ResponseCalculateDTO;
import com.pichincha.springboot.app.tipo.cambio.models.dto.TipocambioDTO;

import java.util.List;

public interface TipocambioServiceProccess {
	public List<TipocambioDTO> listar();
	public TipocambioDTO get(Long id);
	public ResponseCalculateDTO calculate (RequestCalculateDTO requestCalculate);

}
