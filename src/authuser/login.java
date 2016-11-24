/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authuser;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Event;
import com.restfb.types.User;
import com.restfb.types.User.Experience;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * FXML Controller class
 *
 * @author Azeem Tariq'
 */
public class login implements Initializable {

    
    @FXML
    private Button button;
    
    
    
    //@FXML
    //private Label label2;
    //@FXML
    //private Label message;
    //@FXML
    //private ListView<String> ListaEventos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button.setOnAction(this::handleButtonAction);
    }    
    
    @FXML
     private void handleButtonAction(ActionEvent event) {
     // Button was clicked, do something...
     
      String domain = "http://google.com";
        String appId = "1716266622025825";
        
        String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appId+"&redirect_uri="+domain+"&scope=user_about_me,"
                + "user_actions.books,user_actions.fitness,user_actions.music,user_actions.news,user_actions.video,user_birthday,user_education_history,"
                + "user_events,user_photos,user_friends,user_games_activity,user_hometown,user_likes,user_location,user_photos,user_relationship_details,"
                + "user_relationships,user_religion_politics,user_status,user_tagged_places,user_videos,user_website,user_work_history,ads_management,ads_read,email,"
                + "manage_pages,publish_actions,read_insights,read_page_mailboxes,rsvp_event";
        
        System.setProperty("webdirver.chrome.driver", "chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        driver.get(authUrl);
        String accessToken;
        while(true){
        
            if(!driver.getCurrentUrl().contains("facebook.com")){
            String url = driver.getCurrentUrl();
            accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");
            
            driver.quit();
            
                FacebookClient fbClient = new DefaultFacebookClient(accessToken);
                User user = fbClient.fetchObject("me",User.class);
                
     try{
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("AfterLogin.fxml"));
            Parent root1 = (Parent) fxmloader.load();
            Scene stage1 = new Scene(root1);
            Stage login = (Stage) ((Node) event.getSource()).getScene().getWindow();
            login.hide();
            login.setScene(stage1);
            login.show();
            
        }catch(Exception e){
            e.printStackTrace();
        }
     
     
     }
    

    //@FXML
    /*private void authUser(ActionEvent event) {
        
        String domain = "http://google.com";
        String appId = "1716266622025825";
        
        String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appId+"&redirect_uri="+domain+"&scope=user_about_me,"
                + "user_actions.books,user_actions.fitness,user_actions.music,user_actions.news,user_actions.video,user_birthday,user_education_history,"
                + "user_events,user_photos,user_friends,user_games_activity,user_hometown,user_likes,user_location,user_photos,user_relationship_details,"
                + "user_relationships,user_religion_politics,user_status,user_tagged_places,user_videos,user_website,user_work_history,ads_management,ads_read,email,"
                + "manage_pages,publish_actions,read_insights,read_page_mailboxes,rsvp_event";
        
        System.setProperty("webdirver.chrome.driver", "chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        driver.get(authUrl);
        String accessToken;
        while(true){
        
            if(!driver.getCurrentUrl().contains("facebook.com")){
            String url = driver.getCurrentUrl();
            accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");
            
            driver.quit();
            
                FacebookClient fbClient = new DefaultFacebookClient(accessToken);
                User user = fbClient.fetchObject("me",User.class);
                //Connection<Event> eventList =  fbClient.fetchConnection("search", Event.class,
    //Parameter.with("q", "braga"), Parameter.with("type", "event"));
                
                
                //ObservableList<String> items;
                //items = FXCollections.observableArrayList(eventList.toString());
                //ListaEventos.setItems(items);
                
                
                
            /*try{
                FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("AfterLogin.fxml"));
                Parent root1 = (Parent) fxmloader.load();
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root1));
                stage1.show();
            }catch(Exception e){
                e.printStackTrace();
            }*/
              
               
             //message.setText(user.getName());
            
        //    }
        
      //  }
            
    //}*/
   

        }
     }

    
}