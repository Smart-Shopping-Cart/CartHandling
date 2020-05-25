package service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.implement.SignUpService;
import service.interfaces.ISignUpService;
import service.mappers.IMapUser;
import service.mappers.IMapUserImpl;
import service.models.implement.dto.UserDTO;
import service.models.interfaces.dto.IUserDTO;

@Configuration
public class ServiceFactory {

    @Bean
    public IUserDTO getUserDTO(){return new UserDTO(); }

    @Bean
    public IMapUser getMapUser(){return new IMapUserImpl();}

    @Bean
    public ISignUpService getSignUpService(){return new SignUpService();}


}
