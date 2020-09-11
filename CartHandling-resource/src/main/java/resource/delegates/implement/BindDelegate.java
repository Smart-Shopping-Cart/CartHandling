package resource.delegates.implement;

import api.controllers.CartHandlingController.IBindDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import service.interfaces.IBindService;

import javax.inject.Inject;

public class BindDelegate implements IBindDelegate {

  @Inject
    IBindService iBindService;

   @Override
    public String execute(String cameraIp, String userID)
    {
        return iBindService.bind(cameraIp,userID);

    }
}
