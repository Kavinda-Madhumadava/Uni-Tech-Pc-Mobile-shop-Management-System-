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
public class OrderDTO {
    private String RepairID;
    private String Date;
    private String CustomerID;
    private String CustomerNic;
    private String CustomerName;
    private String CustomerAddress;
    private String CustomerContact;
    private String MobileName;
    private String RepairFault;
    private double RepairCost;

    public OrderDTO() {
    }

    public OrderDTO(String RepairID, String Date, String CustomerID, String CustomerNic, String CustomerName, String CustomerAddress, String CustomerContact, String MobileName, String RepairFault, double RepairCost) {
        this.RepairID = RepairID;
        this.Date = Date;
        this.CustomerID = CustomerID;
        this.CustomerNic = CustomerNic;
        this.CustomerName = CustomerName;
        this.CustomerAddress = CustomerAddress;
        this.CustomerContact = CustomerContact;
        this.MobileName = MobileName;
        this.RepairFault = RepairFault;
        this.RepairCost = RepairCost;
    }

    public String getRepairID() {
        return RepairID;
    }

    public void setRepairID(String RepairID) {
        this.RepairID = RepairID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
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

    public String getMobileName() {
        return MobileName;
    }

    public void setMobileName(String MobileName) {
        this.MobileName = MobileName;
    }

    public String getRepairFault() {
        return RepairFault;
    }

    public void setRepairFault(String RepairFault) {
        this.RepairFault = RepairFault;
    }

    public double getRepairCost() {
        return RepairCost;
    }

    public void setRepairCost(double RepairCost) {
        this.RepairCost = RepairCost;
    }
    
    
    
}
