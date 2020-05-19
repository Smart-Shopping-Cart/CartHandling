package resource.delegates.implement;

import api.controllers.CartHandlingController.IUnBindDelegate;
import org.springframework.http.ResponseEntity;

public class UnBindDelegate implements IUnBindDelegate {
    @Override
    public ResponseEntity<String> execute(String customerID) {
        return null;
    }
}
