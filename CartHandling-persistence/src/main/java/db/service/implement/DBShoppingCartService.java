package db.service.implement;

import _generated_sources_openapi_model.Cart;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import db.service.interfaces.IDBShoppingCartService;
import org.bson.types.ObjectId;

import javax.inject.Inject;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.ReturnDocument.AFTER;

public class DBShoppingCartService implements IDBShoppingCartService {

    @Inject
    private MongoCollection<Cart> shoppingCartTable;

    @Override
    public Cart createCart(Cart cart){
        cart.setId(new ObjectId().toHexString());
        shoppingCartTable.insertOne(cart);
        return cart;
    }

    @Override
    public Cart getCart(String id) {
        return shoppingCartTable.find(eq("_id", new ObjectId(id).toHexString())).first();
    }

    @Override
    public long deleteCart(String id) {
        return shoppingCartTable.deleteOne(eq("_id", new ObjectId(id).toHexString())).getDeletedCount();
    }

    @Override
    public Cart updateCart(Cart cart) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return shoppingCartTable.findOneAndReplace(eq("_id", cart.getId()), cart, options);
    }
}
