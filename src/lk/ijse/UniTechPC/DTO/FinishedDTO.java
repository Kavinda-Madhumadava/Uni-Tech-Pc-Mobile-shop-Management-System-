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
public class FinishedDTO {
    private String Fid;
    private String RID;
    private String CustomerID;
    private String MobileName;
    private String ReparFault;
    private double RepairCost;
    private String repDate;

    public FinishedDTO() {
    }

    public FinishedDTO(String Fid, String RID, String CustomerID, String MobileName, String ReparFault, double RepairCost, String repDate) {
        this.Fid = Fid;
        this.RID = RID;
        this.CustomerID = CustomerID;
        this.MobileName = MobileName;
        this.ReparFault = ReparFault;
        this.RepairCost = RepairCost;
        this.repDate = repDate;
    }

    public String getFid() {
        return Fid;
    }

    public void setFid(String Fid) {
        this.Fid = Fid;
    }

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getMobileName() {
        return MobileName;
    }

    public void setMobileName(String MobileName) {
        this.MobileName = MobileName;
    }

    public String getReparFault() {
        return ReparFault;
    }

    public void setReparFault(String ReparFault) {
        this.ReparFault = ReparFault;
    }

    public double getRepairCost() {
        return RepairCost;
    }

    public void setRepairCost(double RepairCost) {
        this.RepairCost = RepairCost;
    }

    public String getRepDate() {
        return repDate;
    }

    public void setRepDate(String repDate) {
        this.repDate = repDate;
    }

    
}
