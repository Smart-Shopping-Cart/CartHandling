package resource.delegates.implement;

import _generated_sources_openapi_model.Cart;
import api.controllers.CartHandlingController.IGetShoppingCartDelegate;
import org.springframework.http.ResponseEntity;

public class GetShoppingCartDelegate implements IGetShoppingCartDelegate {
    @Override
    public ResponseEntity<Cart> execute(String customerID) {
        return null;
    }
}
