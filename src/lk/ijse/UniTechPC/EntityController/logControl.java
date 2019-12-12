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
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DBConnection.DBConnection;

/**
 *
 * @author kavinda
 */
public class logControl {

    public String getPass() throws ClassNotFoundException, SQLException {
//        ResultSet rst = CrudUtil.executeQuery("select * from Login");
//        System.out.println(rst.getString("Password"));
//        return rst.getString("Password");
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * from Login");
        if (rst.next()) {
            System.out.println(rst.getString(2));
            return rst.getString(2);
        }
        return "0";
    }
    
}
