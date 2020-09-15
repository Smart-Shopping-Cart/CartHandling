package resource.delegates.implement;

import api.controllers.CartHandlingController.IAddProductDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import service.interfaces.IAddProductService;

import javax.inject.Inject;

    public class AddProductDelegate implements IAddProductDelegate {

        @Inject
        IAddProductService addProductService;

        @Override
        @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<Void> execute(String cameraIp, String productName)
        {
            addProductService.addProduct(cameraIp,productName);
            return null;
        }
}
