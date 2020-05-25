package resource.delegates.implement;

import _generated_sources_openapi_model.User;
import api.controllers.UserController.ILoginDelegate;
import db.service.interfaces.IDBUserService;
import org.springframework.http.ResponseEntity;

import javax.inject.Inject;


public class LoginDelegate implements ILoginDelegate {

    public ResponseEntity<Void> execute(User user)
    {
        return null;
    }
}
