package com.coderhouse.springbootcoder.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties
public class Config2 {
    @Value(value = "${default.direccion}")
    private String defaultDireccion;
    @Value(value = "${default.nroCasa}")
    private Integer defaultNroCasa;

//    public Direccion direccionPorDefecto() {
//        return new Direccion("Sin dirección", 0);
//    }
}


