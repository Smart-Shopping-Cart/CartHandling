package resource.delegates.implement;

import api.controllers.CartHandlingController.IRemoveProductDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RemoveProductDelegate implements IRemoveProductDelegate {
    @Override
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> execute(String cameraId, String productId)
    {

        return null;
    }
}
