package br.com.caelum.ingresso.configuracao;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
	
	public SecurityInitializer() {
		super(SecurityConfiguration.class);
	}
	
}
