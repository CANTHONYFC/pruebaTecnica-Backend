package com.pichincha.springboot.app.tipo.cambio.controllers;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;
import com.pichincha.springboot.app.tipo.cambio.models.dao.TipocambioDao;
import com.pichincha.springboot.app.tipo.cambio.models.dao.UsuarioDao;
import com.pichincha.springboot.app.tipo.cambio.models.dto.TipocambioDTO;
import com.pichincha.springboot.app.tipo.cambio.models.entity.Tipocambio;
import com.pichincha.springboot.app.tipo.cambio.models.service.TipocambioService;
import com.pichincha.springboot.app.tipo.cambio.models.service.TipocambioServiceProccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/crud")
public class TipocambioController {
	
	private static Logger log = LoggerFactory.getLogger(TipocambioController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	@Qualifier("serviceFeign")
	private TipocambioService itemService;


	@Autowired
	private TipocambioDao tipocambioDao;

	@Autowired
	private TipocambioServiceProccess tipocambioServiceProccess;

	@Autowired
	private UsuarioDao usuarioDao;
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public TipocambioDTO crear(@RequestBody Tipocambio tipocambio,
							@RequestHeader("id_user") String userId) {
		tipocambio.setCreateUser(Long.valueOf(userId));
		Tipocambio t=tipocambioDao.save(tipocambio);
		return tipocambioServiceProccess.get(t.getId());
	}


	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public TipocambioDTO editar(@RequestBody Tipocambio tipocambio, @PathVariable Long id,
								@RequestHeader("id_user") String userId) {
		Optional<Tipocambio> tipocambiot = tipocambioDao.findById(id);
			if(tipocambiot.isPresent()){
				Tipocambio tipocambioUpdate=tipocambiot.get();
				tipocambioUpdate.setNombreOrigen(tipocambio.getMonedaOrigen());
				tipocambioUpdate.setNombreDestino(tipocambio.getMonedaDestino());
				tipocambioUpdate.setPrecio(tipocambio.getPrecio());
					Tipocambio t=tipocambioDao.save(tipocambioUpdate);
	     return tipocambioServiceProccess.get(t.getId());
		}else{
			throw new ResourceNotFoundException("Tipo de cambio no encontrado con ID: " + id);

		}

	}


	@GetMapping("/listar")
	public List<TipocambioDTO> listar(){
		return tipocambioServiceProccess.listar();
	}
	

}
