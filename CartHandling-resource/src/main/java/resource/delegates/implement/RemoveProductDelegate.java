package resource.delegates.implement;

import api.controllers.CartHandlingController.IRemoveProductDelegate;
import org.springframework.http.ResponseEntity;

public class RemoveProductDelegate implements IRemoveProductDelegate {
    @Override
    public ResponseEntity<Void> execute(String cameraId, String productId) {
        return null;
    }
}
