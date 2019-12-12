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
import lk.ijse.UniTechPC.DBConnection.DBConnection;

/**
 *
 * @author kavinda
 */
public class CustomerController {

    public static String genarateID() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select Cid  from Customer order by Cid desc limit 1");

        if (rst.next()) {
            String orderID = rst.getString("Cid");
            orderID = orderID.split("[A-Z]")[1];
            orderID = (Integer.parseInt(orderID) + 1) + "";
            return "C" + orderID;
        } else {
            return "C10001";
        }
    }

}
