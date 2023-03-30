package edu.bu.met.cs665.customer.data;

import edu.bu.met.cs665.interfaces.CustomerData;
import edu.bu.met.cs665.models.Company;

/**
 * Author: Varunkumar G S
 * Email: gsv@bu.edu
 * Date: 03/30/2023
 * Description: concrete class that implements the interface CustomerData.
 */

public class CustomerDatabase implements CustomerData {
    @Override
    public void printCustomer(int id) {
        System.out.println(Company.getCustomers().get(id));
    }

    @Override
    public String getCustomerUsingUsbConnect(int id) {
        return Company.getCustomers().get(id).toString();
    }

}
