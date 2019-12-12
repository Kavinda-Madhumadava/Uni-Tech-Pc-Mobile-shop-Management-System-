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
public class OrderDetail {
    private String OredrId;
    private String ItemCode;
    private double Total;

    public OrderDetail() {
    }

    public OrderDetail(String OredrId, String ItemCode, double Total) {
        this.OredrId = OredrId;
        this.ItemCode = ItemCode;
        this.Total = Total;
    }

    public String getOredrId() {
        return OredrId;
    }

    public void setOredrId(String OredrId) {
        this.OredrId = OredrId;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
}
