package project.aqua_notes.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/api/users/add",
                    "/api/users/getById/**",
                    "/api/users/modifyInfo/**",
                    "/api/users/modifyMail/**",
                    "/api/users/modifyPassword/**",
                    "/api/users/delete/**"
                ).permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }
}
