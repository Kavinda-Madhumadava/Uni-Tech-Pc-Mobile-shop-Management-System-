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
import lk.ijse.UniTechPC.BO.Custom.PlaceOrderBO;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.DTO.PlaceOrderDTO;

/**
 *
 * @author kavinda
 */
public class PlaceOrderController {

    PlaceOrderBO placeOrderBO = (PlaceOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PLACEORDER);

    public boolean placeOrder(PlaceOrderDTO placeOrderDTO) throws Exception {
        return placeOrderBO.PlaceOrder(placeOrderDTO);
    }

    public String getOrders() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select count(Oid) from Orders where Order_Date=curdate()");
        if (rst.next()) {
            return rst.getString(1);
        }
        return "0";
    }

    public String getAllOrders() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(" select count(Oid) from Orders");
        if (rst.next()) {
            return rst.getString(1);
        }
        return "0";
    }

}
