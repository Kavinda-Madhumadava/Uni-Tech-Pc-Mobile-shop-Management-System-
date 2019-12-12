/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DTO;

/**
 *
 * @author kavinda
 */
public class CustomerDTO {
    private String CustomerID;
    private String CustomerNic;
    private String CustomerName;
    private String CustomerAddress;
    private String CustomerContact;

    public CustomerDTO() {
    }

    public CustomerDTO(String CustomerID, String CustomerNic, String CustomerName, String CustomerAddress, String CustomerContact) {
        this.CustomerID = CustomerID;
        this.CustomerNic = CustomerNic;
        this.CustomerName = CustomerName;
        this.CustomerAddress = CustomerAddress;
        this.CustomerContact = CustomerContact;
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

    public String getCustomerContact() {
        return CustomerContact;
    }

    public void setCustomerContact(String CustomerContact) {
        this.CustomerContact = CustomerContact;
    }
    
    
}
