package service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import service.implement.AddProductService;
import service.implement.SignUpService;
import service.interfaces.IAddProductService;
import service.interfaces.ISignUpService;
import service.mappers.*;
import service.models.implement.dto.*;
import service.models.interfaces.dto.*;

@Configuration
public class ServiceFactory {

    @Bean
    @Scope("prototype")

    public IUserDTO getUserDTO() {
        return new UserDTO();
    }

    @Bean
    public IMapUser getMapUser() {
        return new IMapUserImpl();
    }

    @Bean
    public ISignUpService getSignUpService() {
        return new SignUpService();
    }

    @Bean
    @Scope("prototype")
    public ICustomerDTO getCustomerDTO() {
        return new CustomerDTO();
    }

    @Bean
    @Scope("prototype")
    public ICameraDTO getCameraDTO() {
        return new CameraDTO();
    }

    @Bean
    @Scope("prototype")
    public ICartDTO getCartDTO() {
        return new CartDTO();
    }


    @Bean
    @Scope("prototype")
    public IProductDTO getProductDTO() {
        return new ProductDTO();
    }

    @Bean
    public IAddProductService getProductService() {
        return new AddProductService();
    }

    @Bean
    public IMapCustomer getMapCustomer() {
        return new IMapCustomerImpl();
    }

    @Bean
    public IMapCart getMapCart() {
        return new IMapCartImpl();
    }
    @Bean
    public IMapProduct getMapProduct() { return new IMapProductImpl() ; }

}





