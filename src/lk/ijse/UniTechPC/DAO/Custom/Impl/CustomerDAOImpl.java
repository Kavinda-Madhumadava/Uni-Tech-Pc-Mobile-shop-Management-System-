/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DAO.Custom.CustomerDAO;
import lk.ijse.UniTechPC.Entity.Customer;

/**
 *
 * @author kavinda
 */
public class CustomerDAOImpl implements CustomerDAO{
    

    @Override
    public boolean add(Customer t) throws Exception {
        return CrudUtil.executeUpdate("insert into Customer values(?,?,?,?,?);",t.getCustomerID(),t.getCustomerNic(),t.getCustomerName(),t.getCustomerAddress(),t.getContact());
    }

    @Override
    public Customer search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void test() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
