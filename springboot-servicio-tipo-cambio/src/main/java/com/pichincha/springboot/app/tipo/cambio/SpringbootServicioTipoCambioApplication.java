package com.pichincha.springboot.app.tipo.cambio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EntityScan({"com.formacionbdi.springboot.app.commons.usuarios.models.entity", "com.pichincha.springboot.app.tipo.cambio.models.entity"})
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class SpringbootServicioTipoCambioApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioTipoCambioApplication.class, args);
    }

}
