package resource.delegates.implement;

import _generated_sources_openapi_model.Product;
import api.controllers.CartHandlingController.IGetAllProductsDelegate;
import org.springframework.http.ResponseEntity;
import service.interfaces.IGetAlllProductService;

import javax.inject.Inject;
import java.util.List;

public class GetAllProductsDelegate implements IGetAllProductsDelegate {
    @Inject
    IGetAlllProductService getAlllProductService;



    @Override
    public ResponseEntity<List<Product>> execute(String customerID)
    {
        getAlllProductService.getAllProduct();
        return null;
    }
}
