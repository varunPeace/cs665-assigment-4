package edu.bu.met.cs665.interfaces;

/**
 * Author: Varunkumar G S
 * Email: gsv@bu.edu
 * Date: 03/30/2023
 * Description: concrete class that implements the interface CustomerData.
 */

public interface CustomerDataOverHttps {

    void printCustomer(int id);

    String getCustomerUsingHttpsConnect(int id);
}
