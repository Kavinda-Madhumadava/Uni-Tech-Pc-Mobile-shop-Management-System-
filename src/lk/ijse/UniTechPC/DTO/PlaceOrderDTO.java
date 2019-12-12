/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DTO;

import java.util.ArrayList;

/**
 *
 * @author kavinda
 */
public class PlaceOrderDTO {
    private String OrderID;
    private String OrderDate;
    
    private String CustID;
    
    private String ItemCode;
    
    private ArrayList<CustomerDTO>CustomerList;
    
    private ArrayList<OrderDetailDTO>OrderList;

    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(String OrderID, String OrderDate, String CustID, String ItemCode, ArrayList<CustomerDTO> CustomerList, ArrayList<OrderDetailDTO> OrderList) {
        this.OrderID = OrderID;
        this.OrderDate = OrderDate;
        this.CustID = CustID;
        this.ItemCode = ItemCode;
        this.CustomerList = CustomerList;
        this.OrderList = OrderList;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID = CustID;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public ArrayList<CustomerDTO> getCustomerList() {
        return CustomerList;
    }

    public void setCustomerList(ArrayList<CustomerDTO> CustomerList) {
        this.CustomerList = CustomerList;
    }

    public ArrayList<OrderDetailDTO> getOrderList() {
        return OrderList;
    }

    public void setOrderList(ArrayList<OrderDetailDTO> OrderList) {
        this.OrderList = OrderList;
    }
    
    
}
