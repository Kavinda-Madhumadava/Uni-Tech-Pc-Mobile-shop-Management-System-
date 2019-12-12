/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom;

import java.util.ArrayList;
import lk.ijse.UniTechPC.BO.SuperBO;
import lk.ijse.UniTechPC.DTO.ItemDTO;
import lk.ijse.UniTechPC.TM.ItemTM;

/**
 *
 * @author kavinda
 */
public interface ItemBO extends SuperBO {

    public boolean addItem(ItemDTO itemDTO) throws Exception;

    public ArrayList<ItemDTO> getAllItem() throws Exception;

    public ArrayList<ItemDTO> getBy(String Bid) throws Exception;

    public ArrayList<ItemDTO> getItems(String price)throws Exception;

}
