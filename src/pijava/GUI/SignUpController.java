/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pijava.Services.UserServices;
import pijava.entities.User;

/**
 * FXML Controller class
 *
 * @author mohamed
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField Repassword;
    @FXML
    private TextField email;
    @FXML
    private Button btn_valider;
    @FXML
    private TextField name;
    @FXML
    private TextField adresse;
    @FXML
    private TextField telephone;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private Label erreurPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo.getItems().addAll("Parent","Enfant");
                
    }   

    @FXML
    private void CreateUser(ActionEvent event) {
        if(!password.getText().equals(Repassword.getText())){
            erreurPassword.setText("password non identique");
            erreurPassword.setVisible(true);
        }
        else{
        UserServices us=new UserServices();
        User u =new User();
        u.setUsername(username.getText());
        u.setEmail(email.getText());
        u.setPassword(password.getText());
        u.setNom(name.getText());
        u.setAdresse(adresse.getText());
        u.setTelephone(Integer.parseInt(telephone.getText()));
        if(combo.getSelectionModel().getSelectedItem().equals("Parent")){
            u.setRole("a:1:{i:0;s:11:\"ROLE_PARENT\";}");
        }
        us.addUser(u);
        }
    }
    
    
    
}
