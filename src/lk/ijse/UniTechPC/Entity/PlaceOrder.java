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
public class PlaceOrder {

    private String OrderID;
    private String orderDate;
    private String CustomerId;

    public PlaceOrder() {
    }

    public PlaceOrder(String OrderID, String orderDate, String CustomerId) {
        this.OrderID = OrderID;
        this.orderDate = orderDate;
        this.CustomerId = CustomerId;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public boolean addOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
