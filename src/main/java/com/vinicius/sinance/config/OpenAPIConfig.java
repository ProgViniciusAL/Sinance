package com.vinicius.sinance.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Sinance API",
                description = "Finance management API",
                license = @License(name = "MIT"),
                version = "1.0"
        )
)
public class OpenAPIConfig {


}
