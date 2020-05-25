package db.service.implement;


import _generated_sources_openapi_model.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import db.service.interfaces.IDBUserService;
import org.bson.types.ObjectId;

import javax.inject.Inject;

import java.util.Objects;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.ReturnDocument.AFTER;

public class DBUserService implements IDBUserService {
    @Inject
    private MongoCollection<User> userTable;

    @Override
    public User createUser(User user)
    {
        if(Objects.nonNull(getUserByName(user.getName())))
            throw new IllegalStateException("User with this name already exist");
        user.setId(new ObjectId().toHexString());
        userTable.insertOne(user);
        return user;
    }

    @Override
    public User getUser(User user) {
        return userTable.find(and(eq("name",user.getName()),eq("password",user.getPassword()))).first();
    }

    @Override
    public User getUserByName(String name)
    {
        return userTable.find(eq("name",name)).first();
    }

    @Override
    public User getUser(String id) {
        return userTable.find(eq("_id", new ObjectId(id).toHexString())).first();
    }

    @Override
    public long deleteUser(String id) {
        return userTable.deleteOne(eq("_id", new ObjectId(id).toHexString())).getDeletedCount();
    }

    @Override
    public User updateUser(User user) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return userTable.findOneAndReplace(eq("_id", user.getId()), user, options);
    }
}
