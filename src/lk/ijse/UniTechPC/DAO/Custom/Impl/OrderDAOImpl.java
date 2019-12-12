/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO.Custom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DAO.Custom.OrderDAO;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.DTO.CustomerDTO;
import lk.ijse.UniTechPC.Entity.Orders;
import lk.ijse.UniTechPC.EntityController.CustomerController;

/**
 *
 * @author kavinda
 */
public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean add(Orders t) throws Exception {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Orders> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
