/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.TM;

/**
 *
 * @author kavinda
 */
public class ItemTM {
    private String Item_Code;
    private String Bid;
    private String Description;
    private String Unit_Price;
    private String QTY_On_Hand;

    public ItemTM() {
    }

    public ItemTM(String Item_Code, String Bid, String Description, String Unit_Price, String QTY_On_Hand) {
        this.Item_Code = Item_Code;
        this.Bid = Bid;
        this.Description = Description;
        this.Unit_Price = Unit_Price;
        this.QTY_On_Hand = QTY_On_Hand;
    }

    public String getItem_Code() {
        return Item_Code;
    }

    public void setItem_Code(String Item_Code) {
        this.Item_Code = Item_Code;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String Bid) {
        this.Bid = Bid;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getUnit_Price() {
        return Unit_Price;
    }

    public void setUnit_Price(String Unit_Price) {
        this.Unit_Price = Unit_Price;
    }

    public String getQTY_On_Hand() {
        return QTY_On_Hand;
    }

    public void setQTY_On_Hand(String QTY_On_Hand) {
        this.QTY_On_Hand = QTY_On_Hand;
    }
    
    
}
