/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.Controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.UniTechPC.DTO.FinishedDTO;
import lk.ijse.UniTechPC.DTO.HandOverDTO;
import lk.ijse.UniTechPC.DTO.RepairDTO;
import lk.ijse.UniTechPC.Entity.Finished;
import lk.ijse.UniTechPC.EntityController.HangOverController;
import lk.ijse.UniTechPC.EntityController.RepairController;
import lk.ijse.UniTechPC.EntityController.RepairFinishedController;
import lk.ijse.UniTechPC.TM.FinishedRepairTM;
import lk.ijse.UniTechPC.TM.RepairTM;

/**
 * FXML Controller class
 *
 * @author kavinda
 */
public class FinishedController implements Initializable {

    @FXML
    private AnchorPane finishedAnchor;
    @FXML
    private TableView<RepairTM> finishedTBL;
    @FXML
    private TableView<FinishedRepairTM> HandOverTBL;
    @FXML
    private JFXTextField contact;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        finishedTBL.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("RID"));
        finishedTBL.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Cid"));
        finishedTBL.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Mobile_Name"));
        finishedTBL.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Repair_Fault"));
        finishedTBL.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("R_Price"));
        finishedTBL.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("reg_Date"));
        loadItem();

        HandOverTBL.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Fid"));
        HandOverTBL.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("RID"));
        HandOverTBL.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Cid"));
        HandOverTBL.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Mobile_Name"));
        HandOverTBL.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Repair_Fault"));
        HandOverTBL.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("R_Price"));
        HandOverTBL.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("reg_Date"));
        loadFinished();
    }

    private void loadItem() {
        try {
            ArrayList<RepairDTO> rarr = new RepairController().loadAllRepair();
            ArrayList<RepairTM> rtm = new ArrayList<>();
            for (RepairDTO rd : rarr) {
                RepairTM tm = new RepairTM(rd.getRID(), rd.getCustomerID(), rd.getMobileName(), rd.getReparFault(), rd.getRepairCost(), rd.getRepDate());
                rtm.add(tm);
            }
            finishedTBL.setItems(FXCollections.observableArrayList(rtm));
        } catch (Exception ex) {
            Logger.getLogger(AddRepairController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void clickRepaiDone(MouseEvent event) {
        try {
            RepairTM s = finishedTBL.getSelectionModel().getSelectedItem();
            String id = new RepairFinishedController().ID();

            FinishedDTO fto = new FinishedDTO(id, s.getRID(), s.getCid(), s.getMobile_Name(), s.getRepair_Fault(), s.getR_Price(), s.getReg_Date());

            boolean isAdded = new RepairFinishedController().addFinished(fto);
            if (isAdded) {
                loadFinished();
                loadItem();
            } else {
                new Alert(Alert.AlertType.ERROR, "ERROR", ButtonType.CLOSE).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(FinishedController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadFinished() {
        try {
            ArrayList<FinishedDTO> allitem = new RepairFinishedController().getAll();
            ArrayList<FinishedRepairTM> rtm = new ArrayList<>();
            for (FinishedDTO f : allitem) {
                FinishedRepairTM ftm = new FinishedRepairTM(f.getFid(), f.getRID(), f.getCustomerID(), f.getMobileName(), f.getReparFault(), f.getRepairCost(), f.getRepDate());
                rtm.add(ftm);
            }
            HandOverTBL.setItems(FXCollections.observableArrayList(rtm));

        } catch (Exception ex) {
            Logger.getLogger(FinishedController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickHandOver(MouseEvent event) {
        try {
            FinishedRepairTM t = HandOverTBL.getSelectionModel().getSelectedItem();
            String id = new HangOverController().getID();
            HandOverDTO dto=new HandOverDTO(id,t.getFid(),t.getRID(),t.getCid(),t.getMobile_Name(),t.getRepair_Fault(),t.getR_Price(),t.getReg_Date());
            boolean isAdded=new HangOverController().add(dto);
            if (isAdded) {
                loadFinished();
                loadItem();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FinishedController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinishedController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FinishedController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void actionContact(ActionEvent event) {
        try {
            String idd=contact.getText();
            String contact=new RepairFinishedController().getID(idd);
            System.out.println(contact);
            
            String co=new RepairFinishedController().getRepair(contact);
            System.out.println(co);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinishedController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FinishedController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
}
