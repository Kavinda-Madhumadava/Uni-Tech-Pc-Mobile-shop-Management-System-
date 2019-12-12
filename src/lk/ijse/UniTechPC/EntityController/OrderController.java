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
import lk.ijse.UniTechPC.BO.Custom.OrdersBO;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.DTO.OrderDTO;

/**
 *
 * @author kavinda
 */
public class OrderController {

    OrdersBO ordersBO = (OrdersBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDERS);

    public boolean addOrder(OrderDTO orderDTO) throws Exception {
        return ordersBO.addOrder(orderDTO);
    }

    public static String genarateID() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select Oid from Orders order by Oid desc limit 1");

        if (rst.next()) {
            String orderID = rst.getString("Oid");
            orderID = orderID.split("[A-Z]")[1];
            orderID = (Integer.parseInt(orderID) + 1)+"";
            return "O" + orderID;
        } else {
            return "O10001";
        }

    }

}
