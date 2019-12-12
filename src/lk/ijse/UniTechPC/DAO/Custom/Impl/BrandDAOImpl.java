/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DAO.Custom.BrandDAO;
import lk.ijse.UniTechPC.Entity.Brand;

/**
 *
 * @author kavinda
 */
public class BrandDAOImpl implements BrandDAO{

    @Override
    public boolean add(Brand t) throws Exception {
        return CrudUtil.executeUpdate("insert into Brand values(?,?)",t.getBrandID(),t.getBrnadName());
    }

    @Override
    public Brand search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Brand where Brand_Name=?",id);
        Brand brand=null;
        while (rst.next()) {            
            brand=new Brand(rst.getString("Bid"),rst.getString("Brand_Name"));
        }
        return brand;
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Brand> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Brand");
        ArrayList<Brand>arr=new ArrayList<>();
        while (rst.next()) {            
            Brand b=new Brand(rst.getString("Bid"),rst.getString("Brand_Name"));
            arr.add(b);
        }
        return arr;
    }

  
    
}
