package resource.delegates.implement;

import _generated_sources_openapi_model.Product;
import api.controllers.UserController.ILogoutDelegate;
import db.service.interfaces.IDBProductService;
import org.springframework.http.ResponseEntity;

import javax.inject.Inject;

public class LogoutDelegate implements ILogoutDelegate {
    @Inject
    IDBProductService productService;

    @Override
    public ResponseEntity<Void> execute(String authorization) {//todo: logout only delete token at application level
        return null;
    }

}
