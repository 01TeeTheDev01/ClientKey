package com.client.data;

import com.client.classes.Customer;

import java.util.ArrayList;

public class CustomerKeysList
{
    public static ArrayList<String> getCustomerKeysCollectionData() { return customerKeysCollectionData; }
    private static ArrayList<String> customerKeysCollectionData;
    public static ArrayList<Customer> customerCollectedData;
    private static int count = 0;

    public CustomerKeysList()
    {
        customerCollectedData = new ArrayList<>();

        customerKeysCollectionData = new ArrayList<>();
    }

    public Iterable<Customer> iterableCustomerCollectedData(ArrayList<Customer> data) { return data; }

    public static void addCustomerKey(String k)
    {
        if(customerKeysCollectionData.contains(k))
        {
            count += 1;
            customerKeysCollectionData.add(String.format("%s-%s", k, count));
        }
        else
            customerKeysCollectionData.add(k);
    }
}
