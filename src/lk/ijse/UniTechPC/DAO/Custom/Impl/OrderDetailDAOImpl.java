/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DAO.Custom.OrderDetailDAO;
import lk.ijse.UniTechPC.Entity.OrderDetail;

/**
 *
 * @author kavinda
 */
public class OrderDetailDAOImpl implements OrderDetailDAO{

    @Override
    public boolean add(OrderDetail t) throws Exception {
        return CrudUtil.executeUpdate("insert into Order_Details values(?,?,?)",t.getOredrId(),t.getItemCode(),t.getTotal());
    }

    @Override
    public OrderDetail search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
