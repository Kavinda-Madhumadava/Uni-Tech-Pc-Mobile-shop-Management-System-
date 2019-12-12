/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO.Custom;

import java.util.ArrayList;
import lk.ijse.UniTechPC.DAO.CrudDAO;
import lk.ijse.UniTechPC.DTO.ItemDTO;
import lk.ijse.UniTechPC.Entity.Item;
import lk.ijse.UniTechPC.TM.ItemTM;

/**
 *
 * @author kavinda
 */
public interface ItemDAO extends CrudDAO<Item, String>{

    public ArrayList<Item> getByID(String Bid)throws Exception;

    public ArrayList<Item> getI(String price)throws Exception;

   

    
    
}
