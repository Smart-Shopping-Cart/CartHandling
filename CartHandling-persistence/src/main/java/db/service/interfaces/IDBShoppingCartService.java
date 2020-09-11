package db.service.interfaces;

import _generated_sources_openapi_model.Cart;
import _generated_sources_openapi_model.Product;

public interface IDBShoppingCartService {

    Cart createCart(Cart cart);

    Cart createNewCart(String cartid);

    Cart getCart(String id);

    long deleteCart(String id);

    Cart updateCart(Cart cart);

    void addProduct (String cartID, Product product);

}
