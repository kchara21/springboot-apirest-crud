package com.example.springbootapirest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class SpringBootApiRestApplication {

    //Metodo para el mapeo de objetos usando Model Mapper para la refactorización que asigna automáticamente objetos entre sí.
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    // Metodo principal
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiRestApplication.class, args);
    }

}
