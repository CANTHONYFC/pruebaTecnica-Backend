package com.pichincha.springboot.app.tipo.cambio.controllers;

import com.pichincha.springboot.app.tipo.cambio.models.dao.TipocambioDao;
import com.pichincha.springboot.app.tipo.cambio.models.dao.UsuarioDao;
import com.pichincha.springboot.app.tipo.cambio.models.dto.RequestCalculateDTO;
import com.pichincha.springboot.app.tipo.cambio.models.dto.ResponseCalculateDTO;
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
@RequestMapping("/calculate")
public class CalculateController {

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
    @PostMapping("/calculate")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseCalculateDTO calculate(@RequestBody RequestCalculateDTO requestCalculate,
                                      @RequestHeader("id_user") String userId) {
        return tipocambioServiceProccess.calculate(requestCalculate);
    }




}
