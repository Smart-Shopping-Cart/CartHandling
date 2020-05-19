package resource.delegates.implement;

import api.controllers.CartHandlingController.IAddProductDelegate;
import org.springframework.http.ResponseEntity;

public class AddProductDelegate implements IAddProductDelegate {
    @Override
    public ResponseEntity<Void> execute(String cameraId, String productId) {
        return null;
    }
}
