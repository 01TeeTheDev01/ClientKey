package com.client.classes;

import com.client.data.CustomerKeysList;
import com.client.interfaces.ICustomer;
import java.time.LocalDate;

public class CustomerBuilder implements ICustomer {

    private String firstName, middleName,lastName;
    private int age;
    private LocalDate dateOfBirth;
    private Customer customer;
    private static final CustomerKeysList customerKeys = new CustomerKeysList();

    public CustomerBuilder() {}

    public CustomerBuilder(String name1, String name2, String surname, LocalDate DOB, int ageOfCustomer)
    {
        firstName = name1;
        middleName = name2;
        lastName = surname;
        dateOfBirth = DOB;
        age = ageOfCustomer;
    }

    public CustomerBuilder withFirstName(String name) { return new CustomerBuilder(name, middleName, lastName, dateOfBirth, age); }

    public CustomerBuilder withMiddleName(String middle) { return new CustomerBuilder(firstName, middle, lastName, dateOfBirth, age); }

    public CustomerBuilder withLastName(String surname) { return new CustomerBuilder(firstName, middleName, surname, dateOfBirth, age); }

    public CustomerBuilder withDOB(String yyyy, String mm, String dd)
    {
        if (validateDateOfBirth(yyyy, mm, dd))
        {
            dateOfBirth = LocalDate.of(Integer.parseInt(yyyy), Integer.parseInt(mm), Integer.parseInt(dd));
            age = LocalDate.now().getYear() - dateOfBirth.getYear();
        }

        return new CustomerBuilder(firstName, middleName, lastName, dateOfBirth, age);
    }

    public void buildObject()
    {
        //init customer object
        customer = new Customer();

        //define object properties
        customer.setFirstName(firstName);
        customer.setMiddleName(middleName);
        customer.setLastName(lastName);
        customer.setDateOfBirth(dateOfBirth);
        customer.setAge(age);

        //add to list
        CustomerKeysList.customerCollectedData.add(customer);

        //set list to iterable list
        customerKeys.iterableCustomerCollectedData(CustomerKeysList.customerCollectedData); //
    }

    private boolean validateDateOfBirth(String year, String month, String day)
    {
        try
        {
            if(!year.isEmpty() && !month.isEmpty() && !day.isEmpty())
            {
                int yr = Integer.parseInt(year);
                int mm = Integer.parseInt(month);
                int dd = Integer.parseInt(day);

                if ( yr >= 1900 && yr <= LocalDate.now().getYear() && mm > 0 && mm <= 12 && dd > 0 && dd <= 31)
                    return true;
            }
        }
        catch(Exception e)
        {
            return false;
        }

        return false;
    }

    @Override
    public String toString()
    {
        String output = null;

        switch (age)
        {
            case 0:
                if (middleName.isBlank())
                    output = String.format("%s | %s | %s" , lastName, firstName, dateOfBirth);
                else
                    output = String.format("%s | %s | %s | %s", lastName, middleName, firstName, dateOfBirth);
                break;

            case 1:
                if (middleName.isBlank())
                    output =  String.format("%s | %s | %s | %syr old", lastName, firstName, dateOfBirth, age);
                break;

            default:
                if (dateOfBirth != null)
                {
                    if (middleName.isBlank())
                        output = String.format("%s | %s | %s | %syrs old", lastName, firstName, dateOfBirth, age);
                    else
                        output = String.format("%s | %s | %s | %s | %syrs old", lastName, middleName, firstName, dateOfBirth, age);
                }
                else
                {
                    if (middleName.isBlank())
                        output = String.format("%s | %s | %s", lastName, firstName, dateOfBirth);
                    else
                        output = String.format("%s | %s | %s | %s", lastName, middleName, firstName, dateOfBirth);
                }

                break;
        }

        return output;
    }
}
