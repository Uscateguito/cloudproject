package com.cloud.gentebuenagente.microservicio_usuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    

	@Bean
	public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) throws Exception {
		http
			.authorizeExchange((authorize) -> authorize
				.anyExchange().hasAuthority("SCOPE_message.read")
			)
			.oauth2ResourceServer((resourceServer) -> resourceServer
				.jwt(withDefaults())
			);
		return http.build();
	}

}

