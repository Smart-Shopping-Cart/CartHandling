package resource.delegates.implement;

import _generated_sources_openapi_model.Product;
import api.controllers.CartHandlingController.IGetAllProductsDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import service.interfaces.IGetAllProductService;

import javax.inject.Inject;
import java.util.List;

public class GetAllProductsDelegate implements IGetAllProductsDelegate {
    @Inject
    IGetAllProductService getAlllProductService;



    @Override
    public ResponseEntity<List<Product>> execute(String customerID)
    {
        return new ResponseEntity<>(getAlllProductService.getAllProduct(), HttpStatus.OK);
    }
}
