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
import lk.ijse.UniTechPC.BO.Custom.FinishedBO;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.DTO.FinishedDTO;

/**
 *
 * @author kavinda
 */
public class RepairFinishedController {

    FinishedBO finishedBO = (FinishedBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.FINISHED);

    public boolean addFinished(FinishedDTO dto) throws Exception {
        return finishedBO.addFin(dto);
    }

    public String ID() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select Fid from Repair_Finished order by RID desc limit 1");
        if (rst.next()) {
            String id=rst.getString(1);
            id=id.split("[A-Z]")[1];
            id=(Integer.parseInt(id)+1)+"";
            return "F"+id;
        }
        return "F10001";
    }

    public ArrayList<FinishedDTO> getAll() throws Exception {
        return finishedBO.getAllItems();
    }

//    public String getID(String idd) throws ClassNotFoundException, SQLException {
////        ResultSet rst = CrudUtil.executeQuery("select Cid from Customer where Contact=?", idd);
////        if (rst.next()) {
////            
////        }
//    }

    public String getID(String idd) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select Cid from Customer where Contact=?",idd);
        if (rst.next()) {
            return rst.getString(1);
        }
        return "";
    }

    public String getRepair(String co) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Repair where Cid=?",co);
        while (rst.next()) {            
          return rst.getString(2);
        }
        return "";
    }

}
