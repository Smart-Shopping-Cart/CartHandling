package tests.base;


import _generated_sources_openapi_model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import db.config.DBConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import recognition.config.ClientConfig;
import recognition.config.ServiceConfig;
import resource.config.ResourceConfig;
import service.config.ServiceFactory;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceConfig.class, DBConfig.class, ResourceConfig.class, ServiceFactory.class , BaseTestConfig.class, ClientConfig.class} )
public abstract class BaseTests {


    @Inject
    protected ObjectMapper objectMapper;
    @MockBean
    private MongoClient mongoClient;
    @MockBean
    MongoCollection<User> getUsersCollection;
    @MockBean
    MongoCollection<Product> getProductsCollection;
    @MockBean
    MongoCollection<Customer> getCustomersCollection;
    @MockBean
    MongoCollection<Camera> getCamerasCollection;
    @MockBean
    MongoCollection<Cart> getShoppingCartsCollection;
}
