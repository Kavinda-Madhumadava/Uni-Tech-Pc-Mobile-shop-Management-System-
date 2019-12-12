/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO;

import lk.ijse.UniTechPC.DAO.Custom.Impl.BrandDAOImpl;
import lk.ijse.UniTechPC.DAO.Custom.Impl.CustomerDAOImpl;
import lk.ijse.UniTechPC.DAO.Custom.Impl.EmployeeDAOImpl;
import lk.ijse.UniTechPC.DAO.Custom.Impl.FinishedDAOImpl;
import lk.ijse.UniTechPC.DAO.Custom.Impl.HandOverDAOImpl;
import lk.ijse.UniTechPC.DAO.Custom.Impl.ItemDAOImpl;
import lk.ijse.UniTechPC.DAO.Custom.Impl.OrderDAOImpl;
import lk.ijse.UniTechPC.DAO.Custom.Impl.OrderDetailDAOImpl;
import lk.ijse.UniTechPC.DAO.Custom.Impl.PlaceOrderDAOImpl;
import lk.ijse.UniTechPC.DAO.Custom.Impl.RepairDAOImpl;

/**
 *
 * @author kavinda
 */
public class DAOFactory {

    private static DAOFactory dAOFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }

    public enum DAOFactoryTypes {
        EMPLOYEE, ORDERS, CUSTOMER, REPAIR, ITEM, BRAND, PLACEORDER, ORDERDETAIL, FINISHED,HANDOVER;

    }

    public SuperDAO getDAO(DAOFactoryTypes types) {
        switch (types) {
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case ORDERS:
                return new OrderDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case REPAIR:
                return new RepairDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case BRAND:
                return new BrandDAOImpl();
            case PLACEORDER:
                return new PlaceOrderDAOImpl();
            case ORDERDETAIL:
                return new OrderDetailDAOImpl();
            case FINISHED:
                return new FinishedDAOImpl();
                case HANDOVER:
                    return new HandOverDAOImpl();
            default:
                return null;
        }
    }

}
