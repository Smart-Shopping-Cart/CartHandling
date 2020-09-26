package tests.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseTestConfig {

    @Bean
    public ObjectMapper getObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        return objectMapper;
    }
}
