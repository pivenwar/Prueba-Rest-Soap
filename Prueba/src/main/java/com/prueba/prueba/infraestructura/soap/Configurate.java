package com.prueba.prueba.infraestructura.soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Configurate {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.prueba.prueba.wsdl");
        return marshaller;
    }

    @Bean
    public EmpleadoClient empleadoClient(Jaxb2Marshaller marshaller) {
        EmpleadoClient client = new EmpleadoClient();
        client.setDefaultUri("http://localhost:9020/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}