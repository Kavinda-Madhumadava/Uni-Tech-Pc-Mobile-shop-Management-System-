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
import lk.ijse.UniTechPC.BO.BOFactory;
import lk.ijse.UniTechPC.BO.Custom.HandOverBO;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.DTO.HandOverDTO;

/**
 *
 * @author kavinda
 */
public class HangOverController {

    HandOverBO handOverBO = (HandOverBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.HANDOVER);

    public String getID() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select Hid from Handover order by Hid desc limit 1");

        if (rst.next()) {
            String orderID = rst.getString(1);
            orderID = orderID.split("[A-Z]")[1];
            orderID = (Integer.parseInt(orderID) + 1) + "";
            return "H" + orderID;
        } else {
            return "H10001";
        }
    }

    public boolean add(HandOverDTO dto) throws Exception {
        return handOverBO.addHand(dto);
    }

}
