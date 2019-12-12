/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.UniTechPC.DTO.BarndDTO;
import lk.ijse.UniTechPC.DTO.CustomerDTO;
import lk.ijse.UniTechPC.DTO.ItemDTO;
import lk.ijse.UniTechPC.DTO.OrderDetailDTO;
import lk.ijse.UniTechPC.DTO.PlaceOrderDTO;
import lk.ijse.UniTechPC.EntityController.BrandController;

import lk.ijse.UniTechPC.EntityController.CustomerController;
import lk.ijse.UniTechPC.EntityController.ItemController;
import lk.ijse.UniTechPC.EntityController.OrderController;
import lk.ijse.UniTechPC.EntityController.PlaceOrderController;

import lk.ijse.UniTechPC.TM.ItemTM;

/**
 * FXML Controller class
 *
 * @author kavinda
 */
public class DashboardController implements Initializable {

    @FXML
    AnchorPane DashBoardAncher;
    @FXML
    private JFXButton RepairBtn;
    @FXML
    private ImageView dashboardExit;
    @FXML
    private JFXButton makeOrderBtn;
    @FXML
    private ImageView mainAnchor;
    @FXML
    private JFXButton manageItem;
    @FXML
    private JFXButton manageEmployee;
    @FXML
    private JFXButton orderDetail;
    @FXML
    private Label dateLBL;
    @FXML
    private Label orderID;
    @FXML
    private Label CustomerID;
    @FXML
    private JFXComboBox<String> brandCombo;
    @FXML
    private TableView<ItemTM> ItemTBL;
    @FXML
    private Label price;
    @FXML
    private Label description;
    @FXML
    private Label itemCode;
    @FXML
    private JFXTextField CustomerNIC;
    @FXML
    private JFXTextField CustomerName;
    @FXML
    private JFXTextField CustomerAddress;
    @FXML
    private JFXTextField CustomerContact;
    @FXML
    private JFXTextField amount;
    @FXML
    private Label Today;
    @FXML
    private Label AllOrders;
    @FXML
    private JFXTextField Description;
    @FXML
    private ImageView Logout;
    @FXML
    private JFXTextField pricetTXTXXX;
    private double xOffSet = 0;
    private double yOffSet = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        todayOrders();
        dateLBL.setText(LocalDate.now().toString());

        genarateCustomerID();
        genarateOrderID();
        loadBrands();

        ItemTBL.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Item_Code"));
        ItemTBL.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Bid"));
        ItemTBL.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Description"));
        ItemTBL.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Unit_Price"));
        ItemTBL.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("QTY_On_Hand"));
        loadItemTBL();
    }

    @FXML
    private void clickRepairBtn(MouseEvent event) {

        try {
            Node ui1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/UniTechPC/View/AddRepair.fxml"));
            if (!DashBoardAncher.getChildren().isEmpty()) {
                DashBoardAncher.getChildren().remove(0);
            }
            DashBoardAncher.getChildren().add(ui1);
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void clickDashboardExoit(MouseEvent event) {
        System.exit(0);
    }

    private void clickMakeOrder(MouseEvent event) {

    }

    @FXML
    private void clickMangeItem(MouseEvent event) {

    }

    @FXML
    private void clickEmployee(MouseEvent event) {
        try {
            Node ui1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/UniTechPC/View/manageEmplyee.fxml"));
//            if (!DashBoardAncher.getChildren().isEmpty()) {
//                DashBoardAncher.getChildren().remove(0);
//            }
            DashBoardAncher.getChildren().clear();
            DashBoardAncher.getChildren().add(ui1);

        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void genarateCustomerID() {

        try {
            String id = CustomerController.genarateID();
            CustomerID.setText(id);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void genarateOrderID() {
        try {
            String id = new OrderController().genarateID();
            orderID.setText(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadBrands() {
        try {
            ArrayList<BarndDTO> arr = new BrandController().getAllBrands();
            for (BarndDTO brand : arr) {
                brandCombo.getItems().add(brand.getBrandName());
            }
        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void Item(MouseEvent event) {
    }

    @FXML
    private void employeeee(MouseEvent event) {
    }

    @FXML
    private void Repair(MouseEvent event) {
    }

    @FXML
    private void Order(MouseEvent event) {
    }

    @FXML
    private void clickMakeOrder(ActionEvent event) {

        try {
            Parent apn = FXMLLoader.load(getClass().getResource("/lk/ijse/UniTechPC/View/dashboard.fxml"));
            Scene scn = new Scene(apn);
            Stage stage = (Stage) this.makeOrderBtn.getScene().getWindow();
            apn.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffSet = event.getSceneX();
                    yOffSet = event.getSceneY();
                }

            });

            apn.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffSet);
                    stage.setY(event.getScreenY() - yOffSet);

                }

            });

            stage.setScene(scn);
            stage.centerOnScreen();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void manageItem(ActionEvent event) {
        try {
            Node ui1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/UniTechPC/View/manageItem.fxml"));
            if (!DashBoardAncher.getChildren().isEmpty()) {
                DashBoardAncher.getChildren().remove(0);
            }
            DashBoardAncher.getChildren().add(ui1);

        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class
                    .getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void clickRow(MouseEvent event) {
        ItemTM itemtm = ItemTBL.getSelectionModel().getSelectedItem();
        itemCode.setText(itemtm.getItem_Code());
        description.setText(itemtm.getDescription());
        price.setText(itemtm.getUnit_Price());
    }

    @FXML
    private void placeOrder(ActionEvent event) {
        try {
            String OrderID = orderID.getText();
            String OrderDate = dateLBL.getText();

            String CustID = CustomerID.getText();
            String CustNIC = CustomerNIC.getText();
            String CustName = CustomerName.getText();
            String CustAddress = CustomerAddress.getText();
            String CustContact = CustomerContact.getText();

            String ItemCode = itemCode.getText();
            double total = Double.parseDouble(price.getText());

            CustomerDTO customerDTO = new CustomerDTO(CustID, CustNIC, CustName, CustAddress, CustContact);
            ArrayList<CustomerDTO> customerArr = new ArrayList<>();
            customerArr.add(customerDTO);

            OrderDetailDTO orderDetailDTO = new OrderDetailDTO(OrderID, ItemCode, total);
            ArrayList<OrderDetailDTO> orderArr = new ArrayList<>();
            orderArr.add(orderDetailDTO);

            PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO(OrderID, OrderDate, CustID, ItemCode, customerArr, orderArr);

            boolean isAdded = new PlaceOrderController().placeOrder(placeOrderDTO);
            if (isAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Order has Placed", ButtonType.CLOSE);
                alert.show();
                genarateCustomerID();
                genarateOrderID();
                loadBrands();
                loadItemTBL();
                todayOrders();
                clear();

            }
        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void todayOrders() {
        try {
            String orde = new PlaceOrderController().getOrders();
            Today.setText(orde);

            String orders = new PlaceOrderController().getAllOrders();
            AllOrders.setText(orders);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashboardController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ClickloadBrands(ActionEvent event) {
        try {
            String Name = brandCombo.getSelectionModel().getSelectedItem();
            BarndDTO dto = new BrandController().searchID(Name);
            String Bid = dto.getBrandID();
            System.out.println(Bid);
            ArrayList<ItemDTO> itemDTO = new ItemController().getByName(Bid);

            ArrayList<ItemTM> itemTM = new ArrayList<>();
            for (ItemDTO item : itemDTO) {
                ItemTM tM = new ItemTM(item.getItemCode(), item.getBrandID(), item.getDescription(), item.getUnitPrice() + "", item.getQty() + "");
                itemTM.add(tM);

            }
            ItemTBL.setItems(FXCollections.observableArrayList(itemTM));

        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clcikReload(ActionEvent event) {
        genarateCustomerID();
        genarateOrderID();
        loadBrands();
        loadItemTBL();
        todayOrders();
        clear();
    }

    @FXML
    private void clickLogout(MouseEvent event) {
        try {
            Parent apn = FXMLLoader.load(getClass().getResource("/lk/ijse/UniTechPC/View/login.fxml"));
            Scene scn = new Scene(apn);
            Stage stage = (Stage) this.makeOrderBtn.getScene().getWindow();
            apn.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffSet = event.getSceneX();
                    yOffSet = event.getSceneY();
                }

            });

            apn.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffSet);
                    stage.setY(event.getScreenY() - yOffSet);

                }

            });
            stage.setScene(scn);
            stage.centerOnScreen();

        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadItemTBL() {
        try {
            ArrayList<ItemDTO> alitm = new ItemController().loadAllItem();
            ArrayList<ItemTM> itemTM = new ArrayList<>();
            for (ItemDTO item : alitm) {
                ItemTM tM = new ItemTM(item.getItemCode(), item.getBrandID(), item.getDescription(), item.getUnitPrice() + "", item.getQty() + "");
                itemTM.add(tM);

            }
            ItemTBL.setItems(FXCollections.observableArrayList(itemTM));

        } catch (Exception ex) {
            Logger.getLogger(ManageItemController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickOrderDetails(ActionEvent event) {
        try {
            Parent ui1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/UniTechPC/View/report.fxml"));
            DashBoardAncher.getChildren().clear();
            DashBoardAncher.getChildren().add(ui1);

        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Description(ActionEvent event) {
        try {
            String Name = Description.getText();
            BarndDTO dto = new BrandController().searchID(Name);
            String Bid = dto.getBrandID();
            ArrayList<ItemDTO> itemDTO = new ItemController().getByName(Bid);

            ArrayList<ItemTM> itemTM = new ArrayList<>();
            for (ItemDTO item : itemDTO) {
                ItemTM tM = new ItemTM(item.getItemCode(), item.getBrandID(), item.getDescription(), item.getUnitPrice() + "", item.getQty() + "");
                itemTM.add(tM);

            }
            ItemTBL.setItems(FXCollections.observableArrayList(itemTM));

        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void priceTXT(ActionEvent event) {
        try {
            String price = pricetTXTXXX.getText();
            ArrayList<ItemDTO> itemDTOs = new ItemController().getItems(price);

            ArrayList<ItemTM> itemTM = new ArrayList<>();
            for (ItemDTO item : itemDTOs) {
                ItemTM tM = new ItemTM(item.getItemCode(), item.getBrandID(), item.getDescription(), item.getUnitPrice() + "", item.getQty() + "");
                itemTM.add(tM);

            }
            ItemTBL.setItems(FXCollections.observableArrayList(itemTM));

        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void customerNIC(ActionEvent event) {
        CustomerName.requestFocus();
    }

    @FXML
    private void CustomerName(ActionEvent event) {
        CustomerAddress.requestFocus();
    }

    @FXML
    private void custAddres(ActionEvent event) {
        CustomerContact.requestFocus();
    }

    @FXML
    private void custContact(ActionEvent event) {
        amount.requestFocus();
    }

    @FXML
    private void amount(ActionEvent event) {
    }

    private void clear() {
        CustomerNIC.setText("");
        CustomerName.setText("");
        CustomerAddress.setText("");
        CustomerContact.setText("");
        amount.setText("");
    }

}
