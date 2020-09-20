package resource.delegates.implement;

import api.controllers.CartHandlingController.IBindDelegate;
import service.interfaces.IBindService;

import javax.inject.Inject;

public class BindDelegate implements IBindDelegate {

    @Inject
    IBindService iBindService;

    @Override
    public String execute(String cameraIp, String userID) {
        return iBindService.bind(cameraIp, userID);

    }
}
