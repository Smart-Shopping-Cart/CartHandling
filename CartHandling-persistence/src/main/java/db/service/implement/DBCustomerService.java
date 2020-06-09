package db.service.implement;

import _generated_sources_openapi_model.Customer;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import db.service.interfaces.IDBCustomertService;
import org.bson.types.ObjectId;

import javax.inject.Inject;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.ReturnDocument.AFTER;

public class DBCustomerService implements IDBCustomertService {
    @Inject
    private MongoCollection<Customer> customerTable;

    @Override
    public Customer createCustomer(Customer customer){
        customer.setId(new ObjectId().toHexString());
        customerTable.insertOne(customer);
        return customer;
    }



    @Override
    public Customer getCustomer(String id) {
        return customerTable.find(eq("_id", new ObjectId(id).toHexString())).first();
    }
    @Override
    public Customer getCustomerByCameraID(String cameraid)
    {
        Customer customer=customerTable.find(eq("camera.id",cameraid)).first();
        if(customer==null)
        {
            throw new IllegalStateException("camera with this id dosent exist");
        }
        else {
            return (customer);
        }
    }


    @Override
    public long deleteCustomer(String id) {
        return customerTable.deleteOne(eq("_id", new ObjectId(id).toHexString())).getDeletedCount();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return customerTable.findOneAndReplace(eq("_id", customer.getId()), customer, options);
    }
}
