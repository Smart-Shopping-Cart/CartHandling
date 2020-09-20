package resource.delegates.implement;

import api.controllers.CartHandlingController.IUnBindDelegate;
import org.springframework.http.ResponseEntity;
import service.interfaces.IUnBindService;

import javax.inject.Inject;

public class UnBindDelegate implements IUnBindDelegate {

    @Inject
    IUnBindService unBindService;

    @Override
    public ResponseEntity <Void> execute(String customerID) {
        unBindService.unBind(customerID);
        return null;
    }
}
