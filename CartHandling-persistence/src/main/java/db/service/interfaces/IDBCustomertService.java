package db.service.interfaces;

import _generated_sources_openapi_model.Customer;

public interface IDBCustomertService {
    Customer createCustomer(Customer customer);

    Customer getCustomer(String id);

    long deleteCustomer(String id);

    Customer updateCustomer(Customer customer);
}
