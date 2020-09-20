package service.models.implement.dto;

import _generated_sources_openapi_model.Camera;
import _generated_sources_openapi_model.Customer;
import _generated_sources_openapi_model.Token;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import service.models.interfaces.dto.ICameraDTO;
import service.models.interfaces.dto.ICustomerDTO;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerDTO implements ICustomerDTO {
    private String id;
    private String userId;
    private String cartId;
    private String camera;
    @Override

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

    public ICustomerDTO camera(String camera) {
        this.camera = camera;
        return this;
    }
    @Override

    public String getCamera() {
        return camera;
    }
    @Override

    public void setCamera(String camera) {
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
        ICustomerDTO customer = (ICustomerDTO) o;
        return Objects.equals(this.id, customer.getId()) &&
                Objects.equals(this.userId, customer.getUserId()) &&
                Objects.equals(this.cartId, customer.getCartId()) &&
                Objects.equals(this.camera, customer.getCamera());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, cartId, camera);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Customer {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    cartId: ").append(toIndentedString(cartId)).append("\n");
        sb.append("    camera: ").append(toIndentedString(camera)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}


