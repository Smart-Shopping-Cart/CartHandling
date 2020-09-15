package db.service.implement;

import _generated_sources_openapi_model.Product;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import db.service.interfaces.IDBProductService;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.ReturnDocument.AFTER;

public class DBProductService implements IDBProductService {

    @Inject
    private MongoCollection<Product> productTable;

    @Override
    public List<Product> getAllProducts() {
        return productTable.find().into(new ArrayList<Product>());
    }


    @Override
    public Product createProduct(Product product){
        product.setId(new ObjectId().toHexString());
        productTable.insertOne(product);
        return product;
    }

    @Override
    public Product getProduct(String id) {
        return productTable.find(eq("_id", new ObjectId(id).toHexString())).first();
    }

    @Override
    public Product getProductByName(String productName) {
        return productTable.find(eq("name", productName)).first();
    }

    @Override
    public long deleteProduct(String id) {
        return productTable.deleteOne(eq("_id", new ObjectId(id).toHexString())).getDeletedCount();
    }

    @Override
    public Product updateProduct(Product product) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return productTable.findOneAndReplace(eq("_id", product.getId()), product, options);
    }
}
