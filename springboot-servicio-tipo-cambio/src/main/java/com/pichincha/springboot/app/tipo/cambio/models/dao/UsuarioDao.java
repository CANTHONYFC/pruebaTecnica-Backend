package com.pichincha.springboot.app.tipo.cambio.models.dao;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

}
