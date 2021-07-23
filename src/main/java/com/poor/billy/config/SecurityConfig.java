package com.poor.billy.config;

import com.poor.billy.security.JWTUserDetailsService;
import com.poor.billy.security.jwt.JWTConfigurer;
import com.poor.billy.security.jwt.JWTTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true) // Включаем @RolesAllowed
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Fields

    private final JWTUserDetailsService jwtUserDetailsService;


    /**
     * Using BCrypt
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    /**
     * Работаем без внедрения зависимостей, так как возникает цикличность
     *
     * @param userDetailsService - service where override and implements details methods
     * @return JwtTokenProvider
     */
    @Bean
    public JWTTokenProvider jwtTokenProvider(JWTUserDetailsService userDetailsService) {
        return new JWTTokenProvider(userDetailsService);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     * Метод конфигураций.
     * Вместо аннотаций над методами и классами для доступа по ролям,
     * было решено использовать antMatchers с ограничениями по ссылкам (по ролям).
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable().csrf().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(// -- Swagger UI v2
                        "/v2/api-docs",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**",
                        // -- Swagger UI v3 (OpenAPI)
                        "/v3/api-docs/**",
                        "/swagger-ui/**")
                .permitAll()
                .antMatchers("/api/user/registration", "/api/user/login")
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .logout()
                .permitAll()
                .and()
                .apply(new JWTConfigurer(jwtTokenProvider(jwtUserDetailsService)));
    }
}