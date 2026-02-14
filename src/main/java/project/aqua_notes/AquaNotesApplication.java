package project.aqua_notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import project.aqua_notes.Security.JwtProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class AquaNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AquaNotesApplication.class, args);
	}

}
