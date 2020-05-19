package resource.delegates.implement;

import _generated_sources_openapi_model.Product;
import api.controllers.CartHandlingController.IGetProductDelegate;
import org.springframework.http.ResponseEntity;

public class GetProductDelegate implements IGetProductDelegate {
    @Override
    public ResponseEntity<Product> execute(String productId) {
        return null;
    }
}
