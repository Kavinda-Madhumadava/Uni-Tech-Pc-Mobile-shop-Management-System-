/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO;

import lk.ijse.UniTechPC.BO.Custom.Impl.BrandBOImpl;
import lk.ijse.UniTechPC.BO.Custom.Impl.CustomerBOImpl;
import lk.ijse.UniTechPC.BO.Custom.Impl.EmployeeBOImpl;
import lk.ijse.UniTechPC.BO.Custom.Impl.FinishedBOImpl;
import lk.ijse.UniTechPC.BO.Custom.Impl.HandOverBOImpl;
import lk.ijse.UniTechPC.BO.Custom.Impl.ItemBOImpl;
import lk.ijse.UniTechPC.BO.Custom.Impl.OrderBOImpl;
import lk.ijse.UniTechPC.BO.Custom.Impl.OrderDetalBOImpl;
import lk.ijse.UniTechPC.BO.Custom.Impl.PlaceOrderBOImpl;

import lk.ijse.UniTechPC.BO.Custom.Impl.RepairBOImpl;

/**
 *
 * @author kavinda //
 */
public class BOFactory {

    private static BOFactory bOFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }

    public enum BOTypes {
        EMPLOYEE, ORDERS, CUSTOMER, REPAIR, ITEM, BRAND, PLACEORDER, ORDERDETAIL, FINISHED, HANDOVER;
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case EMPLOYEE:
                return (SuperBO) new EmployeeBOImpl();
            case ORDERS:
                return (SuperBO) new OrderBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case REPAIR:
                return new RepairBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case BRAND:
                return new BrandBOImpl();
            case PLACEORDER:
                return new PlaceOrderBOImpl();
            case ORDERDETAIL:
                return (SuperBO) new OrderDetalBOImpl();
            case FINISHED:
                return new FinishedBOImpl();
            case HANDOVER:
                return new HandOverBOImpl();
            default:
                return null;
        }

    }
}
