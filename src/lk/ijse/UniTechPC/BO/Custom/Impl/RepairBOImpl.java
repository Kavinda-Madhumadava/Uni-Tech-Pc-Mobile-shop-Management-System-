/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.UniTechPC.BO.Custom.RepairBO;
import lk.ijse.UniTechPC.DAO.Custom.CustomerDAO;
import lk.ijse.UniTechPC.DAO.Custom.RepairDAO;
import lk.ijse.UniTechPC.DAO.DAOFactory;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.DTO.CustomerDTO;
import lk.ijse.UniTechPC.DTO.RepairDTO;
import lk.ijse.UniTechPC.Entity.Customer;
import lk.ijse.UniTechPC.Entity.Repair;

/**
 *
 * @author kavinda
 */
public class RepairBOImpl implements RepairBO {

    RepairDAO repairDAO = (RepairDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.REPAIR);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.CUSTOMER);

    @Override
    public boolean addRepair(RepairDTO repairDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {

            connection.setAutoCommit(false);
            boolean addCustomer;

            ArrayList<CustomerDTO> cust = repairDTO.getCustomerList();

            for (CustomerDTO c : cust) {
                addCustomer = customerDAO.add(new Customer(c.getCustomerID(),
                        c.getCustomerNic(), c.getCustomerName(),
                        c.getCustomerAddress(), c.getCustomerContact()));

                if (addCustomer) {
                    boolean repairAdded = repairDAO.add(new Repair(repairDTO.getRID(),
                            repairDTO.getCustomerID(), repairDTO.getMobileName(),
                            repairDTO.getReparFault(), repairDTO.getRepairCost(),
                            repairDTO.getRepDate()));

                    if (repairAdded) {
                        connection.commit();
                        return true;
                    }
                }
                connection.rollback();
                return false;
            }
            connection.rollback();
            return false;

        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<RepairDTO> getAllRepair() throws Exception {
        ArrayList<Repair>all=repairDAO.getAll();
        ArrayList<RepairDTO>allDto=new ArrayList<>();
        for(Repair r:all){
            allDto.add(new RepairDTO(r.getRID(),r.getCustomerID(),r.getMobileName(), r.getReparFault(),r.getRepairCost(),r.getRepDate()));
        }
        return allDto;
    }

}
