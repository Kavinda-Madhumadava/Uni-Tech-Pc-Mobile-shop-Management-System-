/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.UniTechPC.BO.Custom.FinishedBO;

import lk.ijse.UniTechPC.DAO.Custom.FinishedDAO;
import lk.ijse.UniTechPC.DAO.Custom.HandOverDAO;
import lk.ijse.UniTechPC.DAO.Custom.RepairDAO;
import lk.ijse.UniTechPC.DAO.DAOFactory;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.DTO.FinishedDTO;
import lk.ijse.UniTechPC.Entity.Finished;

/**
 *
 * @author kavinda
 */
public class FinishedBOImpl implements FinishedBO {

    RepairDAO repairDAO = (RepairDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.REPAIR);
    FinishedDAO finishedDAO = (FinishedDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.FINISHED);
    HandOverDAO handOverDAO = (HandOverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.HANDOVER);
    
     
    @Override
    public boolean addFin(FinishedDTO dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            boolean isAdded = finishedDAO.add(new Finished(dto.getFid(),dto.getRID(),dto.getCustomerID(),dto.getMobileName(),dto.getReparFault(),dto.getRepairCost(),dto.getRepDate()));
            System.out.println(isAdded);
            if (isAdded) {
                connection.commit();
                repairDAO.delete(dto.getRID());
                return true;
            }
            connection.rollback();
            return false;

        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<FinishedDTO> getAllItems() throws Exception {
        ArrayList<Finished> all=finishedDAO.getAll();
        ArrayList<FinishedDTO>dtArr=new ArrayList<>();
        for(Finished f:all){
            dtArr.add(new FinishedDTO(f.getFid(),f.getRID(),f.getCustomerID(),f.getMobileName(),f.getReparFault(),f.getRepairCost(),f.getRepDate()));
        }
        return dtArr;
    }
}
