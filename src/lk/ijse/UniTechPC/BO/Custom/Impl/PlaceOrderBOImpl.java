/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.UniTechPC.BO.Custom.PlaceOrderBO;
import lk.ijse.UniTechPC.DAO.Custom.CustomerDAO;
import lk.ijse.UniTechPC.DAO.Custom.ItemDAO;
import lk.ijse.UniTechPC.DAO.Custom.OrderDetailDAO;
import lk.ijse.UniTechPC.DAO.Custom.PlaceOrderDAO;
import lk.ijse.UniTechPC.DAO.DAOFactory;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.DTO.CustomerDTO;
import lk.ijse.UniTechPC.DTO.ItemDTO;
import lk.ijse.UniTechPC.DTO.OrderDetailDTO;
import lk.ijse.UniTechPC.DTO.PlaceOrderDTO;
import lk.ijse.UniTechPC.Entity.Customer;
import lk.ijse.UniTechPC.Entity.OrderDetail;
import lk.ijse.UniTechPC.Entity.PlaceOrder;

/**
 *
 * @author kavinda
 */
public class PlaceOrderBOImpl implements PlaceOrderBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.ITEM);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.ORDERDETAIL);
    PlaceOrderDAO placeOrderDAO = (PlaceOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.PLACEORDER);

    @Override
    public boolean PlaceOrder(PlaceOrderDTO placeOrderDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            ArrayList<CustomerDTO> customersArr = placeOrderDTO.getCustomerList();
            ArrayList<OrderDetailDTO> orderDetailDTOs = placeOrderDTO.getOrderList();
            for (CustomerDTO c : customersArr) {
                boolean customerAdded = customerDAO.add(new Customer(c.getCustomerID(), c.getCustomerNic(), c.getCustomerName(), c.getCustomerAddress(), c.getCustomerContact()));
                if (customerAdded) {
                    boolean orderAdded = placeOrderDAO.add(new PlaceOrder(placeOrderDTO.getOrderID(), placeOrderDTO.getOrderDate(), placeOrderDTO.getCustID()));
                    if (orderAdded) {
                        for (OrderDetailDTO o : orderDetailDTOs) {
                            boolean isAdd = orderDetailDAO.add(new OrderDetail(o.getOredrId(), o.getItemCode(), o.getTotal()));
                            if (isAdd) {
                                connection.commit();
                                return true;
                            }
                            connection.rollback();
                            return false;
                        }
                        connection.rollback();
                        return false;
                    }
                    connection.rollback();
                    return false;
                }

            }
            connection.rollback();
            return false;
        }finally{
            connection.setAutoCommit(true);
        }
    }

}
