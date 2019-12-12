/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.UniTechPC.BO.Custom.EmployeeBO;
import lk.ijse.UniTechPC.DAO.Custom.EmployeeDAO;
import lk.ijse.UniTechPC.DAO.DAOFactory;
import lk.ijse.UniTechPC.DTO.EmployeeDTO;
import lk.ijse.UniTechPC.Entity.Employee;

/**
 *
 * @author kavinda
 */
public class EmployeeBOImpl implements EmployeeBO{
    EmployeeDAO employeeDAO=(EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.EMPLOYEE);
    @Override
    public boolean addEmployee(EmployeeDTO emp) throws Exception {
        return employeeDAO.add(new Employee(emp.getId(),emp.getName(),emp.getNic(),emp.getAddress(),emp.getDate()));
    }

    @Override
    public EmployeeDTO searchEmployee(String empid) throws Exception {
        Employee emp=employeeDAO.search(empid);
        return new EmployeeDTO(emp.getEmpid(),emp.getEmpName(),emp.getNic(),emp.getEmpAddress(),emp.getRegDate());
    }

    @Override
    public boolean deleteEmployee(String id) throws Exception {
        return employeeDAO.delete(id);
    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmployee() throws Exception {
        ArrayList<Employee> all=employeeDAO.getAll();
        ArrayList<EmployeeDTO>allEmployee=new ArrayList<>();
        for (Employee e : all) {
            allEmployee.add(new EmployeeDTO(e.getEmpid(),e.getEmpName(),e.getNic(),e.getEmpAddress(),e.getRegDate()));
        }
        return allEmployee;
    }

   
    
}
