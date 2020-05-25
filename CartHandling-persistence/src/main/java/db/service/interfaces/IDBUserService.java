package db.service.interfaces;

import _generated_sources_openapi_model.User;

public interface IDBUserService {
    User createUser(User user);

    User getUser(User user);

    User getUserByName(String name);

    User getUser(String id);

    long deleteUser(String id);

    User updateUser(User user);


}
