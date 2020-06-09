package api.controllers;

import _generated_sources_openapi_api.*;
import _generated_sources_openapi_model.Cart;
import _generated_sources_openapi_model.Product;
import _generated_sources_openapi_model.Token;
import api.security.interfaces.ITokenService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Controller
@Scope(value="prototype")
public class CartHandlingController implements AddProductApi, BindApi, GetProductApi, GetShoppingCartApi, ProductsApi,RemoveProductApi,UnbindApi, ApplicationContextAware {

    @Inject
    ITokenService tokenService;

    private ApplicationContext applicationContext;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Product> getProduct(String productId, String authorization) {
        Token token = tokenService.verifyAuthenticationHeader(authorization);
        return this.applicationContext.getBean(CartHandlingController.IGetProductDelegate.class).execute(productId);
    }

    @Override
    public ResponseEntity<Void> addProduct(String cameraId, String productId) {
        return this.applicationContext.getBean(CartHandlingController.IAddProductDelegate.class).execute(cameraId,productId);
    }

    @Override
    public ResponseEntity<String> bind(String cameraIp, String authorization) {
        Token token = tokenService.verifyAuthenticationHeader(authorization);
        return this.applicationContext.getBean(CartHandlingController.IBindDelegate.class).execute(cameraIp,token.getUserId());
    }

    @Override
    public ResponseEntity<Cart> getShoppingCart(String authorization) {
        Token token = tokenService.verifyAuthenticationHeader(authorization);
        return this.applicationContext.getBean(CartHandlingController.IGetShoppingCartDelegate.class).execute(token.getCustomerId());
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts(String authorization) {
        Token token = tokenService.verifyAuthenticationHeader(authorization);
        return this.applicationContext.getBean(CartHandlingController.IGetAllProductsDelegate.class).execute(token.getCustomerId());
    }

    @Override
    public ResponseEntity<Void> removeProduct(String cameraId, String productId) {
        return this.applicationContext.getBean(CartHandlingController.IRemoveProductDelegate.class).execute(cameraId,productId);
    }

    @Override
    public ResponseEntity<String> unbind(String authorization) {
        Token token = tokenService.verifyAuthenticationHeader(authorization);
        return this.applicationContext.getBean(CartHandlingController.IUnBindDelegate.class).execute(token.getCustomerId());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public interface IBindDelegate{
        ResponseEntity<String> execute(String cameraIp ,String userID);
    }
    public interface IUnBindDelegate{
        ResponseEntity<String> execute(String customerID);
    }
    public interface IGetAllProductsDelegate{
        ResponseEntity<List<Product>> execute(String customerID);
    }
    public interface IRemoveProductDelegate{
        ResponseEntity<Void> execute(String cameraId, String productId);
    }
    public interface IGetShoppingCartDelegate{
        ResponseEntity<Cart> execute(String customerID);
    }
    public interface IAddProductDelegate{
        ResponseEntity<Void> execute(String cameraId, String productId);
    }
    public interface IGetProductDelegate{
        Product execute(String productId);
    }
}