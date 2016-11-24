/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authuser;

import com.restfb.types.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alexandre Mirra
 */
public class AfterLoginController implements Initializable {

    @FXML
    private Label label2;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private TextField UserName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
    }    
    
    private void AfterLoginController(ActionEvent event) {
     login controller = new login();
       
       
       User user = controller.getFbclient().fetchObject("me",User.class);
       UserName.setText(user.getName());
    }

    @FXML
    private void initialize(ActionEvent event) {
    }

   
}
