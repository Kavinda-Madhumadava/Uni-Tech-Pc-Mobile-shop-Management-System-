/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DAO.Custom.EmployeeDAO;
import lk.ijse.UniTechPC.Entity.Employee;

/**
 *
 * @author kavinda
 */
public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public boolean add(Employee t) throws Exception {
        return CrudUtil.executeUpdate("insert into Employee values(?,?,?,?,?)",t.getEmpid(),t.getEmpName(),t.getEmpAddress(),t.getNic(),t.getRegDate());
    }

    @Override
    public Employee search(String empid)throws Exception{
        ResultSet rst= CrudUtil.executeQuery("select * from Employee where Employee_Nic =?",empid);
        Employee employee=null;
        while (rst.next()) {            
            employee =new Employee(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
            
        }
        return employee;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from Employee where Employee_Nic=?",id);
    }

    @Override
    public ArrayList<Employee> getAll() throws Exception {
        ResultSet rs=CrudUtil.executeQuery("select * from Employee");
        ArrayList<Employee> employees=new ArrayList<>();
        while (rs.next()) {            
           Employee e=new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
           employees.add(e);
        }
        return employees;
    }

    
    
}
