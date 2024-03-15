package com.pichincha.springboot.app.tipo.cambio.clientes;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "servicio-usuarios")
public interface ProductoClienteRest {

	@GetMapping("/usuarios/{id}")
	public Usuario findById(@PathVariable Long id);



}
