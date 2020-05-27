package resource.delegates.implement;

import api.controllers.UserController.ILogoutDelegate;
import org.springframework.http.ResponseEntity;

public class LogoutDelegate implements ILogoutDelegate {
    @Override
    public ResponseEntity<Void> execute(String authorization) {
        return null;
    }
}
