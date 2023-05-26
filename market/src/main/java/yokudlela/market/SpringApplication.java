package yokudlela.market;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SecurityScheme(
        type = SecuritySchemeType.OPENIDCONNECT,
        name = "openid",
        description = "KeyCloak Yokudlela",
        openIdConnectUrl = "http://localhost:6080/auth/realms/yokudlela/.well-known/openid-configuration"
)
@OpenAPIDefinition(
        servers = {
                @Server(url = "http://localhost:8060/market", description = "local dev")},

        info = @Info(
                title = "Yokudlela Recipes/Menus API",
                version = "v1",
                description = "description = \"Yokudlela Recipes/Tables API for Graphical User Interface .",
                contact = @Contact(name = "Gaál Ruben", email = "gaalruben02@gmail.com")))
@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication
public class SpringApplication {
    public static void main(String[] args)
    {
        org.springframework.boot.SpringApplication.run(SpringApplication.class,args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}
