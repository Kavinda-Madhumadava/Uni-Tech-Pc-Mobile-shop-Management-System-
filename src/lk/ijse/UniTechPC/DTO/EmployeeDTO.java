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
public class EmployeeDTO {
    private String id;
    private String name;
    private String nic;
    private String address;
    private String date;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String id, String name, String nic, String address, String date) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.date = date;
    }

 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}

