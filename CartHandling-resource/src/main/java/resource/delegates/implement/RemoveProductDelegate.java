package resource.delegates.implement;

import api.controllers.CartHandlingController.IRemoveProductDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import service.interfaces.IRemoveProductService;

import javax.inject.Inject;

public class RemoveProductDelegate implements IRemoveProductDelegate {
    @Inject
    IRemoveProductService removeProductService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> execute(String cameraId, String productId)
    {
        removeProductService.removeProduct(cameraId, productId);
        return null;
    }
}
