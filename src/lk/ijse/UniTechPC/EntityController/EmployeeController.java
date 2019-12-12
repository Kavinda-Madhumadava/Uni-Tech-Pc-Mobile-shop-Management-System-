/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.EntityController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.UniTechPC.BO.BOFactory;
import lk.ijse.UniTechPC.BO.Custom.EmployeeBO;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.DTO.EmployeeDTO;

/**
 *
 * @author kavinda
 */
public class EmployeeController {

    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.EMPLOYEE);

    public boolean addEmployee(EmployeeDTO employeeDTO) throws Exception {
        return employeeBO.addEmployee(employeeDTO);

    }

    public EmployeeDTO searchEmployee(String id) throws Exception {
        return employeeBO.searchEmployee(id);
    }

    public boolean deleteEmployee(String id) throws Exception {
        return employeeBO.deleteEmployee(id);
    }

    public String genarateOrderID() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT Emp_Id FROM Employee ORDER BY Emp_Id DESC LIMIT 1");

        if (rst.next()) {
            String orderID = rst.getString(1);
            orderID = orderID.split("[A-Z]")[1];
            orderID = (Integer.parseInt(orderID) + 1) + "";
            return "E" + orderID;
        } else {
            return "E10001";
        }

    }
    public ArrayList<EmployeeDTO> loadAllEmployee()throws Exception{
        return employeeBO.getAllEmployee();
    }

    public String getCount() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select count(Emp_Id)from Employee");
        String id="";
        while (rst.next()) {            
            id=rst.getString(1);
        }
        return id;
    }

}
