package service.models.interfaces.dto;

import _generated_sources_openapi_model.Product;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public interface ICartDTO {
    ICartDTO cartId(String cartId);

    String getCartId();

    void setCartId(String cartId);

    ICartDTO products(List<Product> products);

    ICartDTO addProductsItem(Product productsItem);

    List<Product> getProducts();

    void setProducts(List<Product> products);

    ICartDTO totalPrice(String totalPrice);

    String getTotalPrice();

    void setTotalPrice(String totalPrice);

    ICartDTO id(String id);

    String getId();

    void setId(String id);

    String toIndentedString(Object o);
}
