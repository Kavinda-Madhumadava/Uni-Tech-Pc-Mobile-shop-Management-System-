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
public class Brand {
    private String BrandID;
    private String BrnadName;

    public Brand() {
    }

    public Brand(String BrandID, String BrnadName) {
        this.BrandID = BrandID;
        this.BrnadName = BrnadName;
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String BrandID) {
        this.BrandID = BrandID;
    }

    public String getBrnadName() {
        return BrnadName;
    }

    public void setBrnadName(String BrnadName) {
        this.BrnadName = BrnadName;
    }
    
    
}
