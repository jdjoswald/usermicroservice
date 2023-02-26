package com.UserMicroService.UserMicroService;

import com.UserMicroService.UserMicroService.model.Rol;
import com.UserMicroService.UserMicroService.service.IRolService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroServiceApplication.class, args);
	}
           @Bean
        public CommandLineRunner mappingDemo(IRolService rolService) {
            return args -> {
               /* rolService.guardarRol(new Rol("Admin"));
                rolService.guardarRol(new Rol("User"));*/
            
            };
        }

}
