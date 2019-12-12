/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DAO.Custom.RepairDAO;
import lk.ijse.UniTechPC.Entity.Repair;

/**
 *
 * @author kavinda
 */
public class RepairDAOImpl implements RepairDAO{

    @Override
    public boolean add(Repair t) throws Exception {
        return CrudUtil.executeUpdate("insert into Repair values(?,?,?,?,?,?)", t.getRID(),t.getCustomerID(),t.getMobileName(),t.getReparFault(),t.getRepairCost(),t.getRepDate());
    }

    @Override
    public Repair search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from Repair where RID=?",id);
    }

    @Override
    public ArrayList<Repair> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Repair");
        ArrayList<Repair>repairs=new ArrayList<>();
        while (rst.next()) {            
            Repair r=new Repair(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5),rst.getString(6));
            repairs.add(r);
        }
        return repairs;
    }
    
}
