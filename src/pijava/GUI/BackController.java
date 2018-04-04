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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mohamed
 */
public class BackController implements Initializable {

    @FXML
    private Button btn_categorie;
    @FXML
    private Button btn_dashboard;
    @FXML
    private Button btn_produit;
    @FXML
    private AnchorPane content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void CategoriesButtonAction(ActionEvent event) {      
        
            
        try {
            AnchorPane newLoadedPane =  FXMLLoader.load(getClass().getResource("Categories.fxml"));
            content.getChildren().add(newLoadedPane);
        } catch (IOException ex) {
            Logger.getLogger(BackController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    @FXML
       public void ProduitsButtonAction(ActionEvent event) {      
        
            
        try {
            AnchorPane newLoadedPane =  FXMLLoader.load(getClass().getResource("Produits.fxml"));
            content.getChildren().add(newLoadedPane);
        } catch (IOException ex) {
            Logger.getLogger(BackController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
}
