/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.TM;

import java.sql.Date;

/**
 *
 * @author kavinda
 */
public class EmployeeTM {
    private String Emp_Id;
    private String Employee_Name;
    private String Employee_Nic;
    private String Employee_Address;
    private String Register_Date;

    public EmployeeTM() {
    }

    public EmployeeTM(String Emp_Id, String Employee_Name, String Employee_Nic, String Employee_Address, String Register_Date) {
        this.Emp_Id = Emp_Id;
        this.Employee_Name = Employee_Name;
        this.Employee_Nic = Employee_Nic;
        this.Employee_Address = Employee_Address;
        this.Register_Date = Register_Date;
    }

    public String getEmp_Id() {
        return Emp_Id;
    }

    public void setEmp_Id(String Emp_Id) {
        this.Emp_Id = Emp_Id;
    }

    public String getEmployee_Name() {
        return Employee_Name;
    }

    public void setEmployee_Name(String Employee_Name) {
        this.Employee_Name = Employee_Name;
    }

    public String getEmployee_Nic() {
        return Employee_Nic;
    }

    public void setEmployee_Nic(String Employee_Nic) {
        this.Employee_Nic = Employee_Nic;
    }

    public String getEmployee_Address() {
        return Employee_Address;
    }

    public void setEmployee_Address(String Employee_Address) {
        this.Employee_Address = Employee_Address;
    }

    public String getRegister_Date() {
        return Register_Date;
    }

    public void setRegister_Date(String Register_Date) {
        this.Register_Date = Register_Date;
    }

    
    
    
}
