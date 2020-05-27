package service.models.implement.dto;

import _generated_sources_openapi_model.Camera;
import _generated_sources_openapi_model.Customer;
import _generated_sources_openapi_model.Token;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import service.models.interfaces.dto.ICustomerDTO;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerDTO implements ICustomerDTO {
    private String id;
    private String userId;
    private String cartId;
    private List<Token> token = null;
    private List<Camera> camera = null;


    public ICustomerDTO id(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public ICustomerDTO userId(String userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public String getUserId() {
        return userId;
    }
    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Override
    public ICustomerDTO cartId(String cartId) {
        this.cartId = cartId;
        return this;
    }


    @Override
    public String getCartId() {
        return cartId;
    }
    @Override
    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
    @Override
    public ICustomerDTO token(List<Token> token) {
        this.token = token;
        return this;
    }
    @Override
    public ICustomerDTO addTokenItem(Token tokenItem) {
        if (this.token == null) {
            this.token = new ArrayList<>();
        }
        this.token.add(tokenItem);
        return this;
    }
    @Override
    public List<Token> getToken() {
        return token;
    }
    @Override
    public void setToken(List<Token> token) {
        this.token = token;
    }
    @Override
    public ICustomerDTO camera(List<Camera> camera) {
        this.camera = camera;
        return this;
    }
    @Override
    public ICustomerDTO addCameraItem(Camera cameraItem) {
        if (this.camera == null) {
            this.camera = new ArrayList<>();
        }
        this.camera.add(cameraItem);
        return this;
    }

    @Override
    public List<Camera> getCamera() {
        return camera;
    }
    @Override
    public void setCamera(List<Camera> camera) {
        this.camera = camera;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerDTO customer = (CustomerDTO) o;
        return Objects.equals(this.id, customer.id) &&
                Objects.equals(this.userId, customer.userId) &&
                Objects.equals(this.cartId, customer.cartId) &&
                Objects.equals(this.token, customer.token) &&
                Objects.equals(this.camera, customer.camera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, cartId, token, camera);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Customer {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    cartId: ").append(toIndentedString(cartId)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
        sb.append("    camera: ").append(toIndentedString(camera)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    @Override
    public String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}



