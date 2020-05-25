package db.config;

import _generated_sources_openapi_model.*;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import db.service.implement.*;
import db.service.interfaces.*;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Configuration
public class DBConfig {

    @Value("${mongodb.uri}")
    private String host;

    @Bean
    public MongoClient mongoClient() {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        return MongoClients.create(MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(host))
                .codecRegistry(codecRegistry)
                .build());
    }

    @Bean
    public MongoCollection<User> getUsersCollection(){return mongoClient().getDatabase("CartHandling").getCollection("User", User.class);}

    @Bean
    public MongoCollection<Product> getProductsCollection(){return mongoClient().getDatabase("CartHandling").getCollection("Product", Product.class);}

    @Bean
    public MongoCollection<Customer> getCustomersCollection(){return mongoClient().getDatabase("CartHandling").getCollection("Customer", Customer.class);}

    @Bean
    public MongoCollection<Camera> getCamerasCollection(){return mongoClient().getDatabase("CartHandling").getCollection("Camera", Camera.class);}

    @Bean
    public MongoCollection<Cart> getShoppingCartsCollection(){return mongoClient().getDatabase("CartHandling").getCollection("Cart", Cart.class);}

    @Bean
    IDBUserService getDBUserService(){return new DBUserService();}

    @Bean
    IDBCameraService getDBCameraService(){return new DBCameraService();}

    @Bean
    IDBCustomertService getDBCustomerService(){return new DBCustomerService();}

    @Bean
    IDBProductService getDBProductService(){return new DBProductService();}

    @Bean
    IDBShoppingCartService getDBShoppingCartService(){return new DBShoppingCartService();}

}
