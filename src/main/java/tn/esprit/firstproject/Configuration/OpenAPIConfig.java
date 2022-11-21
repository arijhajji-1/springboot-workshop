package tn.esprit.firstproject.Configuration;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.services.IEtudiantService;
@Configuration

public class OpenAPIConfig {

        @Bean
        public OpenAPI springShopOpenAPI() {
            return new OpenAPI().info(infoAPI());

        }
        public Info infoAPI() {
            return new Info().title("Kaddem").description("TP").contact(contactAPI());

        }
        public Contact contactAPI() {
            Contact contact = new Contact().name("arij").email("arij.hajji@esprit.tn").url("https://www.linkedin.com/in/arij-hajji/");
            return contact;
        }
        @Bean
        public GroupedOpenApi productPublicApi() {
            return GroupedOpenApi.builder()

                    .group("etudiant")

                                    .pathsToMatch("/etudiant/**","/equipe/**","/universite/**","/dep/**","/contrat/**")
                                    .pathsToExclude("**")
                                    .build();

        }

}
