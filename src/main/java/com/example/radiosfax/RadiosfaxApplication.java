package com.example.radiosfax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RadiosfaxApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
		SpringApplication.run(RadiosfaxApplication.class, args);
	}
        
     // pour ajouter /context ==> /Clinique
        @Bean
        public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
          webServerFactoryCustomizer() {
            return factory -> factory.setContextPath("/RadioBackend");
        }
          
       @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(RadiosfaxApplication.class);
        }

      
}
