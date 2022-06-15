package com.client.interfaces;

import com.client.classes.Customer;
import com.client.classes.CustomerBuilder;

public interface ICustomer
{
    CustomerBuilder withFirstName(String name);
    CustomerBuilder withMiddleName(String middle);
    CustomerBuilder withLastName(String surname);
    CustomerBuilder withDOB(String yyyy, String mm, String dd);
    void buildObject();
}
