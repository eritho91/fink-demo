package se.iths.erikthorell.finkdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Tillåt publika sidor
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/register", "/css/**").permitAll()
                        .anyRequest().authenticated()
                )
                // Formlogin inställningar
                .formLogin(form -> form
                        .loginPage("/")                  // Login-formulär på startsidan
                        .loginProcessingUrl("/login")    // POST från formuläret hanteras här
                        .defaultSuccessUrl("/", true)    // Efter login, gå till startsidan
                        .permitAll()
                )
                // Logout inställningar
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}