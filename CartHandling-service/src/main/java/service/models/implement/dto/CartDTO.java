package service.models.implement.dto;

import _generated_sources_openapi_model.Cart;
import _generated_sources_openapi_model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import service.models.interfaces.dto.ICartDTO;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartDTO implements ICartDTO
{

    private String cartId;
    private List<Product> products = null;
    private String totalPrice;
    private String id;

    @Override
    public ICartDTO cartId(String cartId) {
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
    public ICartDTO products(List<Product> products) {
        this.products = products;
        return this;
    }
@Override
    public ICartDTO addProductsItem(Product productsItem) {
        if (this.products == null) {
            this.products = new ArrayList<>();
        }
        this.products.add(productsItem);
        return this;
    }
@Override
    public  ICartDTO removeProductsItem(Product productsItem)
{
    products.remove(productsItem);
    return this;
}
@Override
    public List<Product> getProducts() {
        return products;
    }
@Override
    public void setProducts(List<Product> products) {
        this.products = products;
    }
@Override
    public ICartDTO totalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

@Override
    public String getTotalPrice() {
        return totalPrice;
    }
@Override
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
@Override
    public ICartDTO id(String id) {
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
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CartDTO cart = (CartDTO) o;
        return Objects.equals(this.cartId, cart.cartId) &&
                Objects.equals(this.products, cart.products) &&
                Objects.equals(this.totalPrice, cart.totalPrice) &&
                Objects.equals(this.id, cart.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, products, totalPrice, id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Cart {\n");

        sb.append("    cartId: ").append(toIndentedString(cartId)).append("\n");
        sb.append("    products: ").append(toIndentedString(products)).append("\n");
        sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
