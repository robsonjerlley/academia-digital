package me.dio.academia.digital.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Academia-digital")
                            .version("1.0.0")
                            .description("API para o sistema de uma Academia Digital, desenvolvida para o bootcamp Santander com a DIO.")
                            .termsOfService("https://example.com/terms")
                            .license(new License().name("Apache 2.0").url("https://springdoc.org"))
                            .contact(new Contact().name("Seu Nome").email("seu.email@example.com").url("https://github.com/seu-usuario"))
                    );
        }





}
