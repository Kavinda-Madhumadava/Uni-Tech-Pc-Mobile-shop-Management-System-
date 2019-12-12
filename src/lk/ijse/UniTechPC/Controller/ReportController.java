/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.Controller;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author kavinda
 */
public class ReportController implements Initializable {

    @FXML
    private Label ReportLBL;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ReportLBL.setText("Uni-Tech PC Business Reports");
    }

    private void exitOrders(MouseEvent event) {
//        ReportLBL.setText("Uni-Tech PC Business Reports");
    }

    private void enterOrders(MouseEvent event) {
//        ReportLBL.setText("Order Details");
    }

    private void mouseEnterOrderIncome(MouseEvent event) {
//        ReportLBL.setText("Orders Income");
    }

    private void exitOrderIncome(MouseEvent event) {
//        ReportLBL.setText("Uni-Tech PC Business Reports");
    }

    private void exitCustomerDetails(MouseEvent event) {
//        ReportLBL.setText("Uni-Tech PC Business Reports");
    }

    private void eneterCustomerDetails(MouseEvent event) {
//        ReportLBL.setText("Customer Detils");
    }

    private void exitIncome(MouseEvent event) {
//        ReportLBL.setText("Uni-Tech PC Business Reports");
    }

    private void enterIncome(MouseEvent event) {
//        ReportLBL.setText("Income");
    }

    private void exitItems(MouseEvent event) {
//        ReportLBL.setText("Uni-Tech PC Business Reports");
    }

    private void enterItems(MouseEvent event) {
//        ReportLBL.setText("Item Details");
    }

    @FXML
    private void exitRepair(MouseEvent event) {
//        ReportLBL.setText("Uni-Tech PC Business Reports");
    }

    @FXML
    private void eneterRepair(MouseEvent event) {
//        ReportLBL.setText("Repair Details");
    }

    @FXML
    private void clickRepair(MouseEvent event) {
        try {
            //        InputStream is=this.getClass().getResourceAsStream("/lk/ijse/UniTechPC/View/Report/Uni_Tech_PC.jasper");

            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/UniTechPC/View/Report/Uni_Tech_PC.jasper");
            Connection connection = DBConnection.getInstance().getConnection();
            HashMap map = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(print, false);

        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void exitRepairIncome(MouseEvent event) {
//        ReportLBL.setText("Uni-Tech PC Business Reports");
    }

    private void enterRepairIncome(MouseEvent event) {
//        ReportLBL.setText("Repair Income");
    }

    private void loadRepairDetails() {

    }

    @FXML
    private void clickOrdersIncome(MouseEvent event) {
        try {
            //        InputStream is=this.getClass().getResourceAsStream("/lk/ijse/UniTechPC/View/Report/Uni_Tech_PC.jasper");

            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/UniTechPC/View/Report/OrderDetails.jasper");
            Connection connection = DBConnection.getInstance().getConnection();
            HashMap map = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(print, false);

        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ClickItems(MouseEvent event) {
        try {
            //        InputStream is=this.getClass().getResourceAsStream("/lk/ijse/UniTechPC/View/Report/Uni_Tech_PC.jasper");

            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/UniTechPC/View/Report/ItemReport.jasper");
            Connection connection = DBConnection.getInstance().getConnection();
            HashMap map = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(print, false);

        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickCustomer(MouseEvent event) {
         try {
            //        InputStream is=this.getClass().getResourceAsStream("/lk/ijse/UniTechPC/View/Report/Uni_Tech_PC.jasper");

            InputStream is = this.getClass().getResourceAsStream("/lk/ijse/UniTechPC/View/Report/CustomerDetails.jasper");
            Connection connection = DBConnection.getInstance().getConnection();
            HashMap map = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(print, false);

        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
