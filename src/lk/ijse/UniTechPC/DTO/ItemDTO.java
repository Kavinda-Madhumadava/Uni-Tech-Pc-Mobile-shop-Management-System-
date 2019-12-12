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
public class ItemDTO {
    private String ItemCode;
    private String BrandID;
    private String Description;
    private double UnitPrice;
    private int qty;

    public ItemDTO() {
    }

    public ItemDTO(String ItemCode, String BrandID, String Description, double UnitPrice, int qty) {
        this.ItemCode = ItemCode;
        this.BrandID = BrandID;
        this.Description = Description;
        this.UnitPrice = UnitPrice;
        this.qty = qty;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String BrandID) {
        this.BrandID = BrandID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
}
