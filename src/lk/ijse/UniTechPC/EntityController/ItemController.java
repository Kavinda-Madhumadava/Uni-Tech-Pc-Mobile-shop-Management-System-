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
import lk.ijse.UniTechPC.BO.Custom.ItemBO;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.DTO.ItemDTO;
import lk.ijse.UniTechPC.TM.ItemTM;

/**
 *
 * @author kavinda
 */
public class ItemController {

    ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);

    public ArrayList<ItemDTO> loadAllItem() throws Exception {
        return itemBO.getAllItem();
    }

    public String genarateID() throws SQLException, ClassNotFoundException {
         Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select Item_Code  from Item order by Item_Code desc limit 1");

        if (rst.next()) {
            String orderID = rst.getString("Item_Code");
            orderID = orderID.split("[A-Z]")[1];
            orderID = (Integer.parseInt(orderID) + 1) + "";
            return "I" + orderID;
        } else {
            return "I10001";
        }
    }

    public boolean addItem(ItemDTO itemDTO) throws Exception {
        return itemBO.addItem(itemDTO);
    }

    public ArrayList<ItemDTO> getByName(String Bid) throws Exception {
        return itemBO.getBy(Bid);
    }

    public ArrayList<ItemDTO> getItems(String price) throws Exception {
        return itemBO.getItems(price);
    }

  

}
