package com.skr.empreendimento.rest;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ApplicationPath("/skr")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
    }

    @PostConstruct
    public void setUp() {
        register(EmpreendimentoRest.class);
    }

}