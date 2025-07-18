package com.kubocode.ParkingClubEscritura.security;

import com.kubocode.ParkingClubEscritura.security.filter.JwtAuthenticationFilter;
import com.kubocode.ParkingClubEscritura.util.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Habilitamos CORS indicando que use la configuración de corsConfigurationSource()
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // 2. Deshabilitamos CSRF si no lo usas
                .csrf(csrf -> csrf.disable())
                // 3. No usar sesiones (STATLESS)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 4. Inyectamos tu provider y el filtro JWT
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                // 5. Configuramos las reglas de autorización
                .authorizeHttpRequests(authConfig -> {
                    authConfig.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
                    authConfig.requestMatchers("/error").permitAll();
                    //Privados
                    //Empresa
                    authConfig.requestMatchers(HttpMethod.PUT,"/api/empresas/**").hasAuthority(Permission.ALL_EMPRESAS.name());
                    authConfig.requestMatchers(HttpMethod.POST,"/api/empresas/**").hasAuthority(Permission.ALL_EMPRESAS.name());
                    //Sucursales
                    authConfig.requestMatchers(HttpMethod.PUT,"/api/sucursales/**").hasAuthority(Permission.SELECT_UPDATE_SUCURSALES.name());
                    authConfig.requestMatchers(HttpMethod.POST,"/api/sucursales/**").hasAuthority(Permission.CREATE_SUCURSALES.name());
                    //Empleados
                    authConfig.requestMatchers(HttpMethod.PUT,"/api/empleados/**").hasAuthority(Permission.ALL_EMPLEADOS.name());
                    authConfig.requestMatchers(HttpMethod.POST,"/api/empleados/**").hasAuthority(Permission.ALL_EMPLEADOS.name());
                    authConfig.requestMatchers(HttpMethod.DELETE,"/api/empleados/**").hasAuthority(Permission.ALL_EMPLEADOS.name());
                    //Tickets
                    authConfig.requestMatchers(HttpMethod.PUT,"/tickets/**").hasAuthority(Permission.UPDATE_TICKETS.name());
                    authConfig.requestMatchers(HttpMethod.POST,"/tickets/**").hasAuthority(Permission.READ_TICKETS.name());
                    //Tarifa
                    authConfig.requestMatchers(HttpMethod.PUT,"/tarifa/**").hasAuthority(Permission.ALL_TARIFAS.name());
                    authConfig.requestMatchers(HttpMethod.POST,"/tarifa/**").hasAuthority(Permission.ALL_TARIFAS.name());
                    authConfig.requestMatchers(HttpMethod.PUT,"/tarifa/**").hasAuthority(Permission.ALL_TARIFAS.name());
                    authConfig.requestMatchers(HttpMethod.DELETE,"/tarifa/**").hasAuthority(Permission.ALL_TARIFAS.name());

                    // El resto se deniega
                    authConfig.anyRequest().denyAll();
                });

        return http.build();
    }

    /**
     * Define la configuración CORS para Spring Security:
     * - allowedOrigins: desde dónde puede venir la petición
     * - allowedMethods: métodos permitidos
     * - allowedHeaders: cabeceras que se aceptan
     * - allowCredentials: true si usas cookies/sesiones
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Permite que tu front en localhost:3000 acceda
        configuration.setAllowedOrigins(List.of("http://localhost:3000","http://186.4.230.233","https://parking-club.com","https://186.4.230.233"));
        // Métodos que permites (GET, POST, PUT, DELETE, etc.)
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        // Cabeceras que permites (puedes poner "*")
        configuration.setAllowedHeaders(List.of("*"));
        // Si necesitas enviar cookies/tokens de sesión, pon true
        configuration.setAllowCredentials(true);

        // Registramos la config para todas las rutas
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}