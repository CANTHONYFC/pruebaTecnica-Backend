package com.pichincha.springboot.app.tipo.cambio.models.service;
import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;
import com.pichincha.springboot.app.tipo.cambio.clientes.ProductoClienteRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("serviceFeign")
public class TipocambioServiceFeign implements TipocambioService {
	
	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public Usuario findById(Long id) {
		Usuario usuario = clienteFeign.findById(id);
		return usuario;
	}
}
