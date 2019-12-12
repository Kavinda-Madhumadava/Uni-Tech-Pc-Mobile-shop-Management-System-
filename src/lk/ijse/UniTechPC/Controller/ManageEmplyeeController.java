/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.UniTechPC.DTO.EmployeeDTO;
import lk.ijse.UniTechPC.EntityController.EmployeeController;
import lk.ijse.UniTechPC.TM.EmployeeTM;

/**
 * FXML Controller class
 *
 * @author kavinda
 */
public class ManageEmplyeeController implements Initializable {

    @FXML
    private Label EmployeeID;
    @FXML
    private Label dateLBL;
    @FXML
    private JFXTextField employeeName;
    @FXML
    private JFXTextField nicLbl;
    @FXML
    private JFXTextField EmployeeAddress;
    @FXML
    private JFXButton addBtn;
    @FXML
    private TableView<EmployeeTM> EmployeeTable;
    @FXML
    private Label count;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        genarateId();
        loadCount();
        dateLBL.setText(LocalDate.now().toString());
        EmployeeTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Emp_Id"));
        EmployeeTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Employee_Name"));
        EmployeeTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Employee_Nic"));
        EmployeeTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Employee_Address"));
        EmployeeTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Register_Date"));
        try {
            loadAllEmployee();
        } catch (Exception e) {
        }

    }
    private void loadCount(){
        try {
            String id=new EmployeeController().getCount();
            count.setText(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageEmplyeeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageEmplyeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickRemove(MouseEvent event) {
    }

    @FXML
    private void clickAddBtn(MouseEvent event) {
        try {
            String id = EmployeeID.getText();
            String name = employeeName.getText();
            String nic = nicLbl.getText();
            String date = dateLBL.getText();
            String address = EmployeeAddress.getText();

            EmployeeDTO employeeDTO = new EmployeeDTO(id, name, address, nic, date);
            boolean isAdded = new EmployeeController().addEmployee(employeeDTO);

            if (isAdded) {

                genarateId();
                loadAllEmployee();
                loadCount();
                Clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added Failed", ButtonType.OK);
                alert.show();

            }
        } catch (MySQLIntegrityConstraintViolationException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Employee Already exixts", ButtonType.CLOSE);
            alert.show();
        } catch (Exception ex) {
            Logger.getLogger(ManageEmplyeeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void clickAddEmployee(ActionEvent event) {
    }

    @FXML
    private void enterNIC(ActionEvent event) {

        try {
            String id = nicLbl.getText();

            EmployeeDTO dto = new EmployeeController().searchEmployee(id);

            EmployeeID.setText(dto.getId());
            employeeName.setText(dto.getName());
            EmployeeAddress.setText(dto.getAddress());
            dateLBL.setText(dto.getDate());
        } catch (Exception ex) {
            Logger.getLogger(ManageEmplyeeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void ClickRemove(ActionEvent event) {
        try {
            String id = nicLbl.getText();

            boolean isDeleted = new EmployeeController().deleteEmployee(id);
            if (isDeleted) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Successfully deleted", ButtonType.CLOSE);
                alert.show();
                genarateId();
                loadAllEmployee();
                loadCount();
                Clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Delete failed", ButtonType.CLOSE);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageEmplyeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void genarateId() {
        try {
            String id = new EmployeeController().genarateOrderID();
            EmployeeID.setText(id);
        } catch (Exception ex) {
            Logger.getLogger(ManageEmplyeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Clear() {
        EmployeeAddress.setText("");
        employeeName.setText("");
        nicLbl.setText("");
    }

    private void loadAllEmployee() {
        try {
            ArrayList<EmployeeDTO> allemployee = new EmployeeController().loadAllEmployee();
            ArrayList<EmployeeTM> employeeTMs = new ArrayList<>();
            for (EmployeeDTO employee : allemployee) {
                EmployeeTM tM = new EmployeeTM(employee.getId(), employee.getName(), employee.getNic(), employee.getAddress(), employee.getDate());
                employeeTMs.add(tM);
            }
            EmployeeTable.setItems(FXCollections.observableArrayList(employeeTMs));
        } catch (Exception ex) {
            Logger.getLogger(ManageEmplyeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
