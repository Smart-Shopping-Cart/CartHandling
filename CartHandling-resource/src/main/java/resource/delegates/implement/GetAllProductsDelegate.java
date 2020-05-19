package resource.delegates.implement;

import _generated_sources_openapi_model.Product;
import api.controllers.CartHandlingController.IGetAllProductsDelegate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GetAllProductsDelegate implements IGetAllProductsDelegate {
    @Override
    public ResponseEntity<List<Product>> execute(String customerID) {
        return null;
    }
}
