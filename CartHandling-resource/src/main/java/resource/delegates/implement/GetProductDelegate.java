package resource.delegates.implement;

import _generated_sources_openapi_model.Product;
import api.controllers.CartHandlingController.IGetProductDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import service.interfaces.IGetProductService;

import javax.inject.Inject;

public class GetProductDelegate implements IGetProductDelegate {

    @Inject
    IGetProductService getProductService;

    @Override
    public ResponseEntity<Product> execute(String productId)
    {
        return new ResponseEntity<Product>(getProductService.getProduct(productId), HttpStatus.OK);
    }
}
