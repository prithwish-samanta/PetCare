package dev.prithwish.petcare_monolithic_rest_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI defineOpenApi() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080/petcare/api/v1");
        devServer.setDescription("Development");

        Server prodServer = new Server();
        prodServer.setUrl("http://localhost:8090/petcare/api/v1");
        prodServer.setDescription("Production");

        Contact contact = new Contact();
        contact.setName("Prithwish Samanta");
        contact.setEmail("wprith@gmail.com");
        contact.setUrl("https://github.com/prithwish-samanta");

        Info information = new Info()
                .title("PetCare Monolithic REST API")
                .version("1.0")
                .description("This API exposes endpoints to manage pet clinic.")
                .contact(contact);
        return new OpenAPI().info(information).servers(List.of(devServer, prodServer));
    }
}
