/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authuser;

import com.restfb.types.Event;
import com.restfb.types.User;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    private ListView<String> ListaEventos;
    
    login lg = new login();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    /*private void AfterLoginController(ActionEvent event) {
        login controller = new login();
       
       
       User user = controller.getFbclient().fetchObject("me",User.class);
       label2.setText(user.getName());
    }*/
    
    public void setName(String name){
        label2.setText(name);
    }

    public void setEvento(List<Event> evento){
        ObservableList<String> items;
        items = FXCollections.observableArrayList(evento.toString());
        ListaEventos.setItems(items);
    }

   
}
