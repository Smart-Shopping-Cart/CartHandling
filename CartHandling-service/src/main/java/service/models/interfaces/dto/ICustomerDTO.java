package service.models.interfaces.dto;

import _generated_sources_openapi_model.Camera;
import _generated_sources_openapi_model.Token;

import java.util.List;

public interface ICustomerDTO {
    String getId();

    void setId(String id);

    ICustomerDTO userId(String userId);

    String getUserId();

    void setUserId(String userId);

    ICustomerDTO cartId(String cartId);

    String getCartId();

    void setCartId(String cartId);

    ICustomerDTO token(List<Token> token);

    ICustomerDTO addTokenItem(Token tokenItem);

    List<Token> getToken();

    void setToken(List<Token> token);

    ICustomerDTO camera(List<Camera> camera);

    ICustomerDTO addCameraItem(Camera cameraItem);

    List<Camera> getCamera();

    void setCamera(List<Camera> camera);

    String toIndentedString(Object o);
}
