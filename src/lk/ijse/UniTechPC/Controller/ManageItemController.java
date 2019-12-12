/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import lk.ijse.UniTechPC.DTO.BarndDTO;
import lk.ijse.UniTechPC.DTO.ItemDTO;
import lk.ijse.UniTechPC.EntityController.BrandController;
import lk.ijse.UniTechPC.EntityController.ItemController;
import lk.ijse.UniTechPC.TM.ItemTM;

/**
 * FXML Controller class
 *
 * @author kavinda
 */
public class ManageItemController implements Initializable {

    @FXML
    private Label ItemID;
    @FXML
    private Label dateLBL;
    @FXML
    private JFXComboBox<String> brandCombo;
    @FXML
    private JFXTextField decription;
    @FXML
    private JFXTextField unitPrice;
    @FXML
    private JFXTextField qty;
    @FXML
    private TableView<ItemTM> tblItem;
    @FXML
    private JFXTextField BrandName;
    @FXML
    private Label BrandID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadBrands();
        genarateItemID();
        genarateBarndID();
        dateLBL.setText(LocalDate.now().toString());

        tblItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Item_Code"));
        tblItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Bid"));
        tblItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Description"));
        tblItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Unit_Price"));
        tblItem.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("QTY_On_Hand"));
        try {
            loadAllItem();
        } catch (Exception e) {
        }

    }

    private void loadBrands() {
        try {
            ArrayList<BarndDTO> brn = new BrandController().getAllBrands();
            for (BarndDTO barndDTO : brn) {
                brandCombo.getItems().add(barndDTO.getBrandName());
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void genarateItemID() {

        try {
            String id = new ItemController().genarateID();
            ItemID.setText(id);
        } catch (SQLException ex) {
            Logger.getLogger(ManageItemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageItemController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void clickAddItem(ActionEvent event) {
        try {
            String Name = brandCombo.getSelectionModel().getSelectedItem();
            BarndDTO dto = new BrandController().searchID(Name);
            String Bid = dto.getBrandID();

            String ItemId = ItemID.getText();
            String description = decription.getText();
            int qtys = Integer.parseInt(qty.getText());
            double price = Double.parseDouble(unitPrice.getText());

            ItemDTO itemDTO = new ItemDTO(ItemId, Bid, description, price, qtys);
            boolean isAdded = new ItemController().addItem(itemDTO);
            if (isAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Item Added", ButtonType.CLOSE);
                alert.show();
//                loadAllItem();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Added failed", ButtonType.CLOSE);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageItemController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void clickRemove(ActionEvent event) {
        String id = decription.getText();
    }

    private void loadAllItem() {
        try {
            ArrayList<ItemDTO> alitm = new ItemController().loadAllItem();
            ArrayList<ItemTM> itemTM = new ArrayList<>();
            for (ItemDTO item : alitm) {
                ItemTM tM = new ItemTM(item.getItemCode(), item.getBrandID(), item.getDescription(), item.getUnitPrice() + "", item.getQty() + "");
                itemTM.add(tM);

            }
            tblItem.setItems(FXCollections.observableArrayList(itemTM));
        } catch (Exception ex) {
            Logger.getLogger(ManageItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickTbl(MouseEvent event) {
        ItemTM item = tblItem.getSelectionModel().getSelectedItem();
        decription.setText(item.getDescription());
        ItemID.setText(item.getItem_Code());
        unitPrice.setText(item.getUnit_Price());
        qty.setText(item.getQTY_On_Hand());
    }

    @FXML
    private void AddNewBrand(ActionEvent event) {
        try {
            String bid = BrandID.getText();
            String bname = BrandName.getText();

            BarndDTO dto = new BarndDTO(bid, bname);
            boolean isAdded = new BrandController().addNewBrands(dto);
            if (isAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "New Brand Added", ButtonType.CLOSE);
                alert.show();
                genarateBarndID();
                loadBrands();
                clear();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Added Failed", ButtonType.CLOSE);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void genarateBarndID() {
        try {
            String id = new BrandController().genarateID();
            BrandID.setText(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageItemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clear() {
        BrandName.setText("");

    }

    @FXML
    private void renew(ActionEvent event) {
    }
}
