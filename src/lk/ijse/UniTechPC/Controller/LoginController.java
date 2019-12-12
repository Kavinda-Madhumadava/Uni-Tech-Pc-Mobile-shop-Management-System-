/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.UniTechPC.DAO.CrudUtil;
import lk.ijse.UniTechPC.DBConnection.DBConnection;
import lk.ijse.UniTechPC.EntityController.logControl;

/**
 * FXML Controller class
 *
 * @author kavinda
 */
public class LoginController implements Initializable {

    @FXML
    private ImageView loginExit;
    @FXML
    private JFXButton loginBtn;
    @FXML
    private AnchorPane loginPane;
    @FXML
    private JFXTextField userNameTXT;
    @FXML
    private JFXPasswordField passwordTXt;
    @FXML
    private Label DateLBL;
    @FXML
    private Label timeLBL;
    private double xOffSet = 0;
    private double yOffSet = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadDate();
        loadTime();
    }

    @FXML
    private void clickLoginExit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void clickLoginBtn(MouseEvent event) {
        try {
            String id = userNameTXT.getText();
            String pw = passwordTXt.getText();

            String Encrypt = Encryption.Encrypt(pw);
//            System.out.println(Encrypt);

            String enid = new logControl().getPass();
            
            
            if (Encrypt.equalsIgnoreCase(enid)) {
                Parent apn = FXMLLoader.load(getClass().getResource("/lk/ijse/UniTechPC/View/dashboard.fxml"));
            Scene scn = new Scene(apn);
            Stage stage = (Stage) this.loginBtn.getScene().getWindow();

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

            TranslateTransition tt = new TranslateTransition(Duration.millis(500), scn.getRoot());
            tt.setFromY(+scn.getWidth());
            tt.setToY(0);
            tt.play();
            }else{
                new Alert(Alert.AlertType.ERROR,"Invalid Username or Password",ButtonType.CLOSE).show();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void enterUserName(ActionEvent event) {
        passwordTXt.requestFocus();
    }

    private void loadDate() {
        DateLBL.setText(LocalDate.now().toString());

    }

    private void loadTime() {
        timeLBL.setText(LocalTime.now(ZoneId.systemDefault()).toString());
    }

}
