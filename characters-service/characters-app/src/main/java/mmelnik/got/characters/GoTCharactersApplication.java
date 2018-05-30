package mmelnik.got.characters;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@ApplicationPath("/")
@SpringBootApplication
public class GoTCharactersApplication extends ResourceConfig {

    public GoTCharactersApplication() {
        packages("mmelnik.got.characters.controller");
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(GoTCharactersApplication.class, args);
    }

}
