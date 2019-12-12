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
import lk.ijse.UniTechPC.BO.Custom.BrandBO;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.DTO.BarndDTO;

/**
 *
 * @author kavinda
 */
public class BrandController {

    BrandBO brandBO = (BrandBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BRAND);

    public ArrayList<BarndDTO> getAllBrands() throws Exception {
        return brandBO.getAllBr();

    }

    public BarndDTO searchID(String Name) throws Exception {
        return brandBO.searchName(Name);
    }

    public boolean addNewBrands(BarndDTO dto) throws Exception {
        return brandBO.addBrand(dto);
    }

    public String genarateID() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select Bid  from Brand order by Bid desc limit 1");

        if (rst.next()) {
            String orderID = rst.getString("Bid");
            orderID = orderID.split("[A-Z]")[1];
            orderID = (Integer.parseInt(orderID) + 1) + "";
            return "B" + orderID;
        } else {
            return "B10001";
        }
    }

}
