package resource.delegates.implement;

import _generated_sources_openapi_model.User;
import api.controllers.UserController.ILoginDelegate;
import org.springframework.http.ResponseEntity;

public class LoginDelegate implements ILoginDelegate {
    public ResponseEntity<Void> execute(User user)
    {
        /*todo:*/
        return null;
    }
}
