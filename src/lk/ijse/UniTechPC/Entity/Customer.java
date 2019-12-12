/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.Entity;

/**
 *
 * @author kavinda
 */
public class Customer {
    private String CustomerID;
    private String CustomerNic;
    private String CustomerName;
    private String CustomerAddress;
    private String Contact;

    public Customer() {
    }

    public Customer(String CustomerID, String CustomerNic, String CustomerName, String CustomerAddress, String Contact) {
        this.CustomerID = CustomerID;
        this.CustomerNic = CustomerNic;
        this.CustomerName = CustomerName;
        this.CustomerAddress = CustomerAddress;
        this.Contact = Contact;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerNic() {
        return CustomerNic;
    }

    public void setCustomerNic(String CustomerNic) {
        this.CustomerNic = CustomerNic;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String CustomerAddress) {
        this.CustomerAddress = CustomerAddress;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }
    
    
    
}
