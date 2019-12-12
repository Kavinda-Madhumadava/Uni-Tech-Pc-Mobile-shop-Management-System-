/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DAO.Custom.PlaceOrderDAO;
import lk.ijse.UniTechPC.Entity.PlaceOrder;

/**
 *
 * @author kavinda
 */
public class PlaceOrderDAOImpl implements PlaceOrderDAO{

    @Override
    public boolean add(PlaceOrder t) throws Exception {
        return CrudUtil.executeUpdate("insert into Orders value(?,?,?)",t.getOrderID(),t.getOrderDate(),t.getCustomerId());
    }

    @Override
    public PlaceOrder search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PlaceOrder> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
