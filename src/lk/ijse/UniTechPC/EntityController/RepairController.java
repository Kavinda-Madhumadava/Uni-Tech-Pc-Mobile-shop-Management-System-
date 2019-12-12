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
import lk.ijse.UniTechPC.BO.Custom.RepairBO;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.DTO.RepairDTO;

/**
 *
 * @author kavinda
 */
public class RepairController {

    RepairBO repairBO = (RepairBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REPAIR);

    public static String genarateID() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select RID  from Repair order by RID desc limit 1");

        if (rst.next()) {
            String orderID = rst.getString("RID");
            orderID = orderID.split("[A-Z]")[1];
            orderID = (Integer.parseInt(orderID) + 1) + "";
            return "R" + orderID;
        } else {
            return "R10001";
        }

    }

    public ArrayList<RepairDTO> loadAllRepair() throws Exception {
        return repairBO.getAllRepair();
    }

    public boolean addRepair(RepairDTO repairDTO) throws Exception {
        return repairBO.addRepair(repairDTO);
    }

    public String getCount() throws SQLException, ClassNotFoundException {
       
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(" select count(RID) from Repair where reg_Date=curdate()");
        if (rst.next()) {
            return rst.getString(1);
        }
        return "0";
    }

}
