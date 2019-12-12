/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lk.ijse.UniTechPC.DBConnection.DBConnection;

/**
 *
 * @author kavinda
 */
public class CrudUtil {

    private static PreparedStatement getPreparedStatement(String sql, Object... parms) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i = 0; i < parms.length; i++) {
            pstm.setObject(i + 1, parms[i]);

        }
        return pstm;
    }

    public static boolean executeUpdate(String sql, Object... parms) throws ClassNotFoundException, SQLException {
        return getPreparedStatement(sql, parms).executeUpdate()>0;
    }
    public static ResultSet executeQuery(String sql,Object...params) throws ClassNotFoundException, SQLException{
        return getPreparedStatement(sql, params).executeQuery();
    }
}
