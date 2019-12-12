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
public class FinishedRepairTM {
    private String Fid;
    private String RID;
    private String Cid;
    private String Mobile_Name;
    private String Repair_Fault;
    private double R_Price;
    private String reg_Date;

    public FinishedRepairTM() {
    }

    public FinishedRepairTM(String Fid, String RID, String Cid, String Mobile_Name, String Repair_Fault, double R_Price, String reg_Date) {
        this.Fid = Fid;
        this.RID = RID;
        this.Cid = Cid;
        this.Mobile_Name = Mobile_Name;
        this.Repair_Fault = Repair_Fault;
        this.R_Price = R_Price;
        this.reg_Date = reg_Date;
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

    public String getCid() {
        return Cid;
    }

    public void setCid(String Cid) {
        this.Cid = Cid;
    }

    public String getMobile_Name() {
        return Mobile_Name;
    }

    public void setMobile_Name(String Mobile_Name) {
        this.Mobile_Name = Mobile_Name;
    }

    public String getRepair_Fault() {
        return Repair_Fault;
    }

    public void setRepair_Fault(String Repair_Fault) {
        this.Repair_Fault = Repair_Fault;
    }

    public double getR_Price() {
        return R_Price;
    }

    public void setR_Price(double R_Price) {
        this.R_Price = R_Price;
    }

    public String getReg_Date() {
        return reg_Date;
    }

    public void setReg_Date(String reg_Date) {
        this.reg_Date = reg_Date;
    }
    
    
}
