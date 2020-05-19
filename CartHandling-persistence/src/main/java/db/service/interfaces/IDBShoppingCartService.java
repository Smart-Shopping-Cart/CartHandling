package db.service.interfaces;

import _generated_sources_openapi_model.Cart;

public interface IDBShoppingCartService {

    Cart createCart(Cart cart);

    Cart getCart(String id);

    long deleteCart(String id);

    Cart updateCart(Cart cart);
}
