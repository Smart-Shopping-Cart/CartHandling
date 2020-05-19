package resource.delegates.implement;

import api.controllers.CartHandlingController.IBindDelegate;
import org.springframework.http.ResponseEntity;

public class BindDelegate implements IBindDelegate {
    @Override
    public ResponseEntity<String> execute(String cameraIp, String userID) {
        return null;
    }
}
