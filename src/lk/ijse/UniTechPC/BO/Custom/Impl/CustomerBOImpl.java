/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom.Impl;

import lk.ijse.UniTechPC.BO.Custom.CustomerBO;
import lk.ijse.UniTechPC.DAO.Custom.CustomerDAO;
import lk.ijse.UniTechPC.DAO.DAOFactory;
import lk.ijse.UniTechPC.DTO.CustomerDTO;
import lk.ijse.UniTechPC.Entity.Customer;

/**
 *
 * @author kavinda
 */
public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customerDTO)throws Exception{
        return customerDAO.add(new Customer(customerDTO.getCustomerID(), customerDTO.getCustomerNic(),customerDTO.getCustomerName(),customerDTO.getCustomerAddress(),customerDTO.getCustomerContact()));
    }

}
