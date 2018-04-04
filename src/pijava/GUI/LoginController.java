/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pijava.Services.UserServices;

/**
 * FXML Controller class
 *
 * @author mohamed
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button btn_cnx;
    @FXML
    private Label erreur;
    @FXML
    private ImageView logo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        

    }   

    @FXML
    private void LoginAction(ActionEvent event) { 
        UserServices us=new UserServices();
        Boolean test;
        test= us.Authentificate(username.getText(), password.getText());
        pijava.PIJava.user=us.Login(username.getText(), password.getText());
        if(test){
            if (pijava.PIJava.user.getRole().equals("ROLE_ADMIN")){
               System.out.println("this is an Admin"); 
               erreur.setText("Logged in as Admin");
               Parent root = null;
                try {
                    
                    root = FXMLLoader.load(getClass().getResource("back.fxml"));
                    Scene s1 = new Scene(root);
                    Stage primaryStage=new Stage();
                    primaryStage.setScene(s1);
                    primaryStage.show();
                    
                    Stage actualStage = (Stage) btn_cnx.getScene().getWindow();
                    actualStage.close();
                    
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
               btn_cnx.getScene().setRoot(root);
               
            }
            if(pijava.PIJava.user.getRole().equals("ROLE_PARENT")) {
               System.out.println("this is a Parent"); 
               erreur.setText("Logged in as Parent");
                
            }
        }
        else{
            erreur.setText("Failed, Try again !");
        }
        erreur.setVisible(true);
    }
    
}
