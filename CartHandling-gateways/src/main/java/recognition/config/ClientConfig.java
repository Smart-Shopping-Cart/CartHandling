package recognition.config;

import _generated_sources_openapi_api.CameraApi;
import _generated_sources_openapi_invokers.ApiClient;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
    @Value("${recognition.url:http://localhost:5000}")
    private String baseUrl;
    @Bean
    CameraApi getCameraApi(){
        ApiClient apiClient= new ApiClient();
        apiClient.setBasePath(baseUrl);
        Feign.Builder feignBuilder = new Feign.Builder();
        feignBuilder.encoder(new JacksonEncoder(apiClient.getObjectMapper()));
        feignBuilder.decoder(new JacksonDecoder(apiClient.getObjectMapper()));
        feignBuilder.logger(new Slf4jLogger(CameraApi.class));
        feignBuilder.logLevel(Logger.Level.FULL);
        apiClient.setFeignBuilder(feignBuilder);
        return apiClient.buildClient(CameraApi.class);
    }
}
