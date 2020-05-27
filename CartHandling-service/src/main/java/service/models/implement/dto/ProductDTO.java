package service.models.implement.dto;

import _generated_sources_openapi_model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import service.models.interfaces.dto.IProductDTO;

import java.util.Objects;

public class ProductDTO implements IProductDTO
{

    private String id;
    private String price;

    @Override
    public ProductDTO id(String id) {
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

    public ProductDTO price(String price) {
        this.price = price;
        return this;
    }
    @Override

    public String getPrice() {
        return price;
    }
    @Override

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductDTO product = (ProductDTO) o;
        return Objects.equals(this.id, product.id) &&
                Objects.equals(this.price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Product {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("}");
        return sb.toString();
    }
    @Override
    public String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
