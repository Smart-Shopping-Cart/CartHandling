package api.config;

import api.security.implement.TokenService;
import api.security.interfaces.ITokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    @Bean
    ITokenService getTokenService(){return new TokenService();}
}
