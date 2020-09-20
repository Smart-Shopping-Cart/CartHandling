package service.models.interfaces.dto;

import _generated_sources_openapi_model.Product;

import java.util.List;

public interface ICartDTO {

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

    public  ICartDTO removeProductsItem(Product productsItem);
}
