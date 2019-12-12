/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom.Impl;

import java.sql.Connection;
import lk.ijse.UniTechPC.BO.Custom.HandOverBO;
import lk.ijse.UniTechPC.DAO.Custom.FinishedDAO;
import lk.ijse.UniTechPC.DAO.Custom.HandOverDAO;
import lk.ijse.UniTechPC.DAO.DAOFactory;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.DTO.HandOverDTO;
import lk.ijse.UniTechPC.Entity.HandOver;

/**
 *
 * @author kavinda
 */
public class HandOverBOImpl implements HandOverBO {

    HandOverDAO handOverDAO = (HandOverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.HANDOVER);
    FinishedDAO finishedDAO = (FinishedDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.FINISHED);

    @Override
    public boolean addHand(HandOverDTO dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            boolean isAdded = handOverDAO.add(new HandOver(dto.getHid(), dto.getFid(), dto.getRID(), dto.getCustomerID(), dto.getMobileName(), dto.getReparFault(), dto.getRepairCost(), dto.getRepDate()));
            if (isAdded) {
                connection.commit();
                finishedDAO.delete(dto.getFid());
                return true;
            }
            connection.rollback();
            return false;
        }finally{
            connection.setAutoCommit(true);
        }
    }

}
