package jp.te4a.spring.boot.myapp13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//import java.lang.CharSequence;


@EnableWebSecurity
@Configuration

public class SecurityConfig extends WebSecurityConfiguration{
    //private HttpSecurity customHttpSecurity;
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring().requestMatchers(
            new AntPathRequestMatcher("/webjars/**"),
            new AntPathRequestMatcher("/css/**"),
            new AntPathRequestMatcher("/error")

        );
    }

    @Bean
    static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/loginForm", "/users").permitAll()
                .requestMatchers("/users/add").permitAll()
                .requestMatchers("/users/create").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginProcessingUrl("/login")
                .loginPage("/loginForm")
                .defaultSuccessUrl("/books")
                .failureUrl("/loginForm?error")
                .usernameParameter("username").passwordParameter("password")
                .permitAll()
            )
            
            .logout(logout -> logout
                .logoutSuccessUrl("/loginForm")
            );

            return http.build();
    }
}
