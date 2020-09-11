package service.models.interfaces.dto;

import _generated_sources_openapi_model.Camera;
import _generated_sources_openapi_model.Token;

import java.util.List;

public interface ICustomerDTO {


    ICustomerDTO id(String id);

    String getId();

    void setId(String id);

    ICustomerDTO userId(String userId);

    String getUserId();

    void setUserId(String userId);

    ICustomerDTO cartId(String cartId);

    String getCartId();

    void setCartId(String cartId);

    ICustomerDTO camera(String camera);

    String getCamera();

    void setCamera(String camera);
}
