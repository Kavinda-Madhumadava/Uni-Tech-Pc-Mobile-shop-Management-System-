/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom;

import java.util.ArrayList;
import lk.ijse.UniTechPC.BO.SuperBO;
import lk.ijse.UniTechPC.DTO.EmployeeDTO;

/**
 *
 * @author kavinda
 */
public interface EmployeeBO extends SuperBO {

    public boolean addEmployee(EmployeeDTO employeeDTO) throws Exception;

    public EmployeeDTO searchEmployee(String empid) throws Exception;

    public boolean deleteEmployee(String id) throws Exception;
    
    public ArrayList<EmployeeDTO>getAllEmployee()throws Exception;

    
}
