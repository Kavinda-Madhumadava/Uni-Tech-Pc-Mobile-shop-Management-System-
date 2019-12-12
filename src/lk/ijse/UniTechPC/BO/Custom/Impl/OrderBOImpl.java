/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom.Impl;

import lk.ijse.UniTechPC.BO.Custom.OrdersBO;
import lk.ijse.UniTechPC.DAO.Custom.OrderDAO;
import lk.ijse.UniTechPC.DAO.DAOFactory;
import lk.ijse.UniTechPC.DTO.OrderDTO;
import lk.ijse.UniTechPC.Entity.Orders;

/**
 *
 * @author kavinda
 */
public class OrderBOImpl implements OrdersBO{
    OrderDAO orderDAO=(OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.ORDERS);
    
    @Override
    public boolean addOrder(OrderDTO orderDTO) throws Exception {
        return orderDAO.add(new Orders(orderDTO.getRepairID(),orderDTO.getDate(),orderDTO.getCustomerID(),orderDTO.getCustomerNic(),orderDTO.getCustomerName(), orderDTO.getCustomerAddress(),orderDTO.getCustomerContact(),orderDTO.getMobileName(),orderDTO.getRepairFault(),orderDTO.getRepairCost()));
    }
    
}
