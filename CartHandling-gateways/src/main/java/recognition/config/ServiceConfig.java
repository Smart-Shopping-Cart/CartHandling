package recognition.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import recognition.implementation.RecognitionGateWay;

@Configuration
public class ServiceConfig {
    @Bean
    public RecognitionGateWay getRecognitionGateWay(){return new RecognitionGateWay();}
}
