package resource.delegates.implement;

import _generated_sources_openapi_model.User;
import api.controllers.UserController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import service.mappers.IMapUser;
import service.interfaces.ISignUpService;

import javax.inject.Inject;

public class SingUpDelegate implements UserController.ISignUpDelegate {

    @Inject
    ISignUpService signUpService;

    @Inject
    IMapUser mapUser;

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> execute(User user) {
        signUpService.createUser(mapUser.mapUserEntityToDTO(user));
        return null;
    }
}
