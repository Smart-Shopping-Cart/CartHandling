package resource.config;

import api.controllers.CartHandlingController.IUnBindDelegate;
import api.controllers.CartHandlingController.IRemoveProductDelegate;
import api.controllers.CartHandlingController.IGetShoppingCartDelegate;
import api.controllers.CartHandlingController.IGetProductDelegate;
import api.controllers.CartHandlingController.IGetAllProductsDelegate;
import api.controllers.CartHandlingController.IAddProductDelegate;
import api.controllers.CartHandlingController.IBindDelegate;
import api.controllers.UserController.ILoginDelegate;
import api.controllers.UserController.ILogoutDelegate;
import api.controllers.UserController.ISignUpDelegate;
import db.config.DBConfig;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import resource.delegates.implement.*;

@Configuration
@AutoConfigureAfter(DBConfig.class)
public class ResourceConfig {
    @Bean
    ISignUpDelegate getSignUpDelegate(){return new SingUpDelegate();}
    @Bean
    ILoginDelegate getLoginDelegate(){return new LoginDelegate();}
    @Bean
    ILogoutDelegate getLogoutDelegate(){return new LogoutDelegate();}
    @Bean
    IAddProductDelegate getAddProductDelegate(){return new AddProductDelegate();}
    @Bean
    IBindDelegate getBindDelegate(){return new BindDelegate();}
    @Bean
    IGetAllProductsDelegate getGetAllProductsDelegate(){return new GetAllProductsDelegate();}
    @Bean
    IGetProductDelegate getGetProductDelegate(){return new GetProductDelegate();}
    @Bean
    IGetShoppingCartDelegate getGetShoppingCartDelegate(){return new GetShoppingCartDelegate();}
    @Bean
    IRemoveProductDelegate getRemoveProductDelegate(){return new RemoveProductDelegate();}
    @Bean
    IUnBindDelegate getUnBindDelegate(){return new UnBindDelegate();}

}
