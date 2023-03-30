package edu.bu.met.cs665;

import edu.bu.met.cs665.customer.data.CustomerDatabase;
import edu.bu.met.cs665.customer.data.CustomerDatabaseUsbToHttpsAdapter;
import edu.bu.met.cs665.customer.data.CustomerDataFromHttpsServer;
import edu.bu.met.cs665.interfaces.CustomerData;
import edu.bu.met.cs665.interfaces.CustomerDataOverHttps;
import edu.bu.met.cs665.models.Company;
import edu.bu.met.cs665.models.Customer;
import edu.bu.met.cs665.models.Gender;

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test
    public void AdapterTest() {
        // Create customer
        Customer customer1 = new Customer("Harry", Gender.MALE);
        Customer customer2 = new Customer("Rose", Gender.FEMALE);
        Customer customer3 = new Customer("Jay", Gender.OTHER);

        // Add customers to database
        Company.addCustomer(customer1);
        Company.addCustomer(customer2);
        Company.addCustomer(customer3);

        // Get Id
        int customerID1 = customer1.getCustomerID();
        int customerID2 = customer2.getCustomerID();
        int customerID3 = customer3.getCustomerID();

        // Get data from external disk via old system
        CustomerData myCustomerDataDisk = new CustomerDatabase();
        String actual1 = "ID: 1, Name: Harry, Gender: MALE";
        assertEquals(myCustomerDataDisk.getCustomerUsingUsbConnect(customerID1), actual1);

        // Get data from external server via the new system
        CustomerDataOverHttps myCustomerDataOverHttpsServer = new CustomerDataFromHttpsServer();
        String actual2 = "ID: 2, Name: Rose, Gender: FEMALE";
        assertEquals(myCustomerDataOverHttpsServer.getCustomerUsingHttpsConnect(customerID2), actual2);

        // Get data from external disk via old system
        CustomerData otherCustomerDataDisk = new CustomerDatabase();
        String actual3 = "ID: 3, Name: Jay, Gender: OTHER";
        assertEquals(otherCustomerDataDisk.getCustomerUsingUsbConnect(customerID3), actual3);

        // Get data from external server via the old system
        CustomerData myCustomerData = new CustomerDatabaseUsbToHttpsAdapter(myCustomerDataOverHttpsServer);
        assertEquals(myCustomerData.getCustomerUsingUsbConnect(customerID2), actual2);

    }

}
