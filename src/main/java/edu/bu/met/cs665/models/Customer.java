package edu.bu.met.cs665.models;

/**
 * Author: Varunkumar G S
 * Email: gsv@bu.edu
 * Date: 03/30/2023
 * Description: concrete class that implements the interface CustomerData.
 */

public class Customer {

    private String name;
    private Gender gender;
    private static int randomNum = 1;
    private int id;

    public Customer(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        id = randomNum++; // assign id at instantiation
    }

    public int getCustomerID() {
        return id;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Gender: " + gender;
    }

}
