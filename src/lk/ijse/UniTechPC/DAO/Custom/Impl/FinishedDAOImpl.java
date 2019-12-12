/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DAO.Custom.FinishedDAO;
import lk.ijse.UniTechPC.Entity.Finished;

/**
 *
 * @author kavinda
 */
public class FinishedDAOImpl implements FinishedDAO{

    @Override
    public boolean add(Finished t) throws Exception {
        return CrudUtil.executeUpdate("insert into Repair_Finished values(?,?,?,?,?,?,?)",t.getFid(),t.getRID(),t.getCustomerID(),t.getMobileName(),t.getReparFault(),t.getRepairCost(),t.getRepDate());
    }

    @Override
    public Finished search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from Repair_Finished where Fid=?", id);
    }

    @Override
    public ArrayList<Finished> getAll() throws Exception {
        ResultSet rst=CrudUtil.executeQuery("select * from Repair_Finished");
        ArrayList<Finished>farr=new ArrayList<>();
        while (rst.next()) {            
            Finished f=new Finished(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getDouble(6),rst.getString(7));
            farr.add(f);
        }
        return farr;
    }

  
    
}
