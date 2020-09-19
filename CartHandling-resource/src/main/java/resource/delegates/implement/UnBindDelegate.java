package resource.delegates.implement;

import api.controllers.CartHandlingController.IUnBindDelegate;
import org.springframework.http.ResponseEntity;

public class UnBindDelegate implements IUnBindDelegate {
    @Override
    public ResponseEntity <Void> execute(String customerID) {
        return null;
    }
}
