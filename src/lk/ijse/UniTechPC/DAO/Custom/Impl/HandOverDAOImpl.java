/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.Entity.HandOver;
import lk.ijse.UniTechPC.DAO.Custom.HandOverDAO;

/**
 *
 * @author kavinda
 */
public class HandOverDAOImpl implements HandOverDAO{

    @Override
    public boolean add(HandOver t) throws Exception {
        return CrudUtil.executeUpdate("insert into Handover values(?,?,?,?,?,?,?,?)",t.getHid(),t.getFid(),t.getRID(),t.getCustomerID(),t.getMobileName(),t.getReparFault(),t.getRepairCost(),t.getRepDate());
    }

    @Override
    public HandOver search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<HandOver> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
