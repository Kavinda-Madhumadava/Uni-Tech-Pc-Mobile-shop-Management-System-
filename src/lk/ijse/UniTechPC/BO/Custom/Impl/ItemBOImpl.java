/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.UniTechPC.BO.Custom.ItemBO;
import lk.ijse.UniTechPC.DAO.Custom.ItemDAO;
import lk.ijse.UniTechPC.DAO.DAOFactory;
import lk.ijse.UniTechPC.DTO.ItemDTO;
import lk.ijse.UniTechPC.Entity.Item;
import lk.ijse.UniTechPC.TM.ItemTM;

/**
 *
 * @author kavinda
 */
public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.ITEM);

    @Override
    public boolean addItem(ItemDTO itemDTO) throws Exception {
        return itemDAO.add(new Item(itemDTO.getItemCode(), itemDTO.getBrandID(), itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQty()));
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws Exception {

        ArrayList<Item> all = itemDAO.getAll();
        ArrayList<ItemDTO> allitem = new ArrayList<>();
        for (Item i : all) {
            allitem.add(new ItemDTO(i.getItemCode(), i.getBrandID(), i.getDescription(), i.getUnitPrice(), i.getQty()));

        }
        return allitem;
    }

    @Override
    public ArrayList<ItemDTO> getBy(String Bid) throws Exception {
        ArrayList<Item> all = itemDAO.getByID(Bid);
        ArrayList<ItemDTO> allitem = new ArrayList<>();
        for (Item i : all) {
            allitem.add(new ItemDTO(i.getItemCode(), i.getBrandID(), i.getDescription(), i.getUnitPrice(), i.getQty()));
        }
        return allitem;
    }

    @Override
    public ArrayList<ItemDTO> getItems(String price) throws Exception {
        ArrayList<Item> all = itemDAO.getI(price);
        ArrayList<ItemDTO> allitem = new ArrayList<>();
        for (Item i : all) {
            allitem.add(new ItemDTO(i.getItemCode(), i.getBrandID(), i.getDescription(), i.getUnitPrice(), i.getQty()));
        }
        return allitem;
    }

}
