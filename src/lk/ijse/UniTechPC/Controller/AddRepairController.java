/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.UniTechPC.DTO.CustomerDTO;
import lk.ijse.UniTechPC.DTO.RepairDTO;
import lk.ijse.UniTechPC.EntityController.CustomerController;
import lk.ijse.UniTechPC.EntityController.RepairController;

import lk.ijse.UniTechPC.TM.RepairTM;

/**
 * FXML Controller class
 *
 * @author kavinda
 */
public class AddRepairController implements Initializable {

    @FXML
    private AnchorPane RepairAnchor;
    @FXML
    private JFXButton finished;
    private Label repairID;
    @FXML
    private Label dtaeLBL;
    @FXML
    private Label customerID;
    @FXML
    private JFXTextField CustomerNIC;
    @FXML
    private JFXTextField customerName;
    @FXML
    private JFXTextField customerAddress;
    @FXML
    private JFXTextField customerContact;
    @FXML
    private JFXTextField repairMobile;
    @FXML
    private JFXTextField repairDescription;
    @FXML
    private JFXTextField Cost;
    private Label RIDLBL;
    @FXML
    private Label ridLBL;
    @FXML
    private TableView<RepairTM> repairTBL;
    @FXML
    private Label TodayRepair;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        genarateRepairID();
        genarateCustomerID();
        dtaeLBL.setText(LocalDate.now().toString());

        repairTBL.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("RID"));
        repairTBL.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Cid"));
        repairTBL.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Mobile_Name"));
        repairTBL.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Repair_Fault"));
        repairTBL.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("R_Price"));
        repairTBL.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("reg_Date"));

        loadRepairDetail();
        TodayRepairs();
    }

    @FXML
    private void clickedFinished(MouseEvent event) {
        try {
            Node ui1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/UniTechPC/View/finished.fxml"));
            if (!RepairAnchor.getChildren().isEmpty()) {
                RepairAnchor.getChildren().remove(0);
            }
            RepairAnchor.getChildren().add(ui1);
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void clickAddRepair(MouseEvent event) {

    }

    private void genarateRepairID() {

        try {
            String id = RepairController.genarateID();
            ridLBL.setText(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddRepairController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddRepairController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void genarateCustomerID() {
        try {
            String id = CustomerController.genarateID();
            customerID.setText(id);
        } catch (SQLException ex) {
            Logger.getLogger(AddRepairController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddRepairController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadRepairDetail() {
        try {
            ArrayList<RepairDTO> rarr = new RepairController().loadAllRepair();
            ArrayList<RepairTM> rtm = new ArrayList<>();
            for (RepairDTO rd : rarr) {
                RepairTM tm = new RepairTM(rd.getRID(), rd.getCustomerID(), rd.getMobileName(), rd.getReparFault(), rd.getRepairCost(), rd.getRepDate());
                rtm.add(tm);
            }
            repairTBL.setItems(FXCollections.observableArrayList(rtm));
        } catch (Exception ex) {
            Logger.getLogger(AddRepairController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void AddRepair(ActionEvent event) {
        try {
            String rid = ridLBL.getText();

            String date = dtaeLBL.getText();

            String custId = customerID.getText();

            String nic = CustomerNIC.getText();

            String name = customerName.getText();
            String address = customerAddress.getText();
            String contact = customerContact.getText();

            String mobile = repairMobile.getText();
            String description = repairDescription.getText();
            double price = Double.parseDouble(Cost.getText());

            CustomerDTO customerDTO = new CustomerDTO(custId, nic, name, address, contact);

            ArrayList<CustomerDTO> CustomerList = new ArrayList<>();

            CustomerList.add(customerDTO);

            RepairDTO repairDTO = new RepairDTO(rid, custId, mobile, description, price, date, CustomerList);

            boolean isAdded = new RepairController().addRepair(repairDTO);
            if (isAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added to Repair", ButtonType.CLOSE);
                alert.show();
                genarateCustomerID();
                genarateRepairID();
                loadRepairDetail();
                clears();

            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added Failed", ButtonType.CLOSE);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(AddRepairController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void CustomerNIC(ActionEvent event) {
        customerName.requestFocus();
    }

    @FXML
    private void CustomerName(ActionEvent event) {
        customerAddress.requestFocus();
    }

    @FXML
    private void CustomerAddress(ActionEvent event) {
        customerContact.requestFocus();
    }

    @FXML
    private void CustomerContact(ActionEvent event) {
        repairMobile.requestFocus();
    }

    @FXML
    private void CancelRepair(ActionEvent event) {
        clears();
    }

    @FXML
    private void RepairMobile(ActionEvent event) {
        repairDescription.requestFocus();
    }

    @FXML
    private void Description(ActionEvent event) {
        Cost.requestFocus();
    }

    @FXML
    private void Price(ActionEvent event) {
        try {
            String rid = ridLBL.getText();

            String date = dtaeLBL.getText();

            String custId = customerID.getText();

            String nic = CustomerNIC.getText();

            String name = customerName.getText();
            String address = customerAddress.getText();
            String contact = customerContact.getText();

            String mobile = repairMobile.getText();
            String description = repairDescription.getText();
            double price = Double.parseDouble(Cost.getText());

            CustomerDTO customerDTO = new CustomerDTO(custId, nic, name, address, contact);

            ArrayList<CustomerDTO> CustomerList = new ArrayList<>();

            CustomerList.add(customerDTO);

            RepairDTO repairDTO = new RepairDTO(rid, custId, mobile, description, price, date, CustomerList);

            boolean isAdded = new RepairController().addRepair(repairDTO);
            if (isAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added to Repair", ButtonType.CLOSE);
                alert.show();
                genarateCustomerID();
                genarateRepairID();
                loadRepairDetail();
                clears();

            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added Failed", ButtonType.CLOSE);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(AddRepairController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void clears() {
        CustomerNIC.setText("");
        customerAddress.setText("");
        customerContact.setText("");
        customerName.setText("");

        repairDescription.setText("");
        repairMobile.setText("");
        Cost.setText("");
    }

    private void TodayRepairs() {
        try {
            String id=new RepairController().getCount();
            System.out.println(id);
            TodayRepair.setText(id);
        } catch (SQLException ex) {
            Logger.getLogger(AddRepairController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddRepairController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
