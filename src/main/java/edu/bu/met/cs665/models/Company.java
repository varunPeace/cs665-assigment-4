package edu.bu.met.cs665.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Varunkumar G S
 * Email: gsv@bu.edu
 * Date: 03/30/2023
 * Description: concrete class that implements the interface CustomerData.
 */

public class Company {

    private static final Map<Integer, Customer> customers = new HashMap<>();

    public static void addCustomer(Customer customer) {
        customers.put(customer.getCustomerID(), customer);
    }

    public static Map<Integer, Customer> getCustomers() {
        return new HashMap<>(customers);
    }

}
