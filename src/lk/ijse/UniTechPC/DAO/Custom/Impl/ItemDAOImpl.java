/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO.Custom.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DAO.Custom.ItemDAO;
import lk.ijse.UniTechPC.DTO.ItemDTO;
import lk.ijse.UniTechPC.Entity.Item;
import lk.ijse.UniTechPC.TM.ItemTM;

/**
 *
 * @author kavinda
 */
public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean add(Item t) throws Exception {
        return CrudUtil.executeUpdate("insert into Item values(?,?,?,?,?)", t.getItemCode(), t.getBrandID(), t.getDescription(), t.getUnitPrice(), t.getQty());
    }

    @Override
    public Item search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Item> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from Item");
        ArrayList<Item> items = new ArrayList<>();
        while (rst.next()) {
            Item i = new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getInt(5));
            items.add(i);
        }
        return items;
    }

    @Override
    public ArrayList<Item> getByID(String Bid) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Item where Bid=?", Bid);
        ArrayList<Item> items = new ArrayList<>();
        while (rst.next()) {
            Item i = new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getInt(5));
            items.add(i);
        }
        return items;
    }

    @Override
    public ArrayList<Item> getI(String price) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Item where Unit_Price<=? order by Unit_Price desc",price);
        ArrayList<Item> items = new ArrayList<>();
        while (rst.next()) {
            Item i = new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getInt(5));
            items.add(i);
        }
        return items;
    }

}
