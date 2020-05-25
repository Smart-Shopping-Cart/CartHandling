package api.controllers;

import _generated_sources_openapi_api.LoginApi;
import _generated_sources_openapi_api.LogoutApi;
import _generated_sources_openapi_api.SignUpApi;
import _generated_sources_openapi_model.User;
import api.security.interfaces.ITokenService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import javax.inject.Inject;
import java.util.Optional;

@Controller
@Scope(value="prototype")
public class UserController implements LoginApi, SignUpApi, LogoutApi, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Inject
    ITokenService tokenService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }
    @Override
    public ResponseEntity<String> login(User user) {
        String token=tokenService.buildJwtToken(user);
        this.applicationContext.getBean(UserController.ILoginDelegate.class).execute(user);
        return new ResponseEntity<String>(token, HttpStatus.ACCEPTED);
    }
    @Override
    public ResponseEntity<Void> logout(String authorization) {
        return this.applicationContext.getBean(UserController.ILogoutDelegate.class).execute(authorization);
    }

    @Override
    public ResponseEntity<Void> signUp(User user) {
        return this.applicationContext.getBean(UserController.ISignUpDelegate.class).execute(user);
    }

    public interface ISignUpDelegate{
        ResponseEntity<Void> execute(User user);
    }
    public interface ILoginDelegate{
        ResponseEntity<Void> execute(User user);
    }
    public interface ILogoutDelegate{
        ResponseEntity<Void> execute(String authorization);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
