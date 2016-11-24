/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authuser;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 *
 * @author alexandremirra
 */
public class Main extends Application {
   
    
      @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("CleverE - Eventos da Cidade de Braga");
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    } 
    
   
    

    /*  *********INICIA OS AGENTES *******
    
    
jade.core.Runtime rt;
ContainerController container;
   
    
    public void initMainContainer(String host, String port) {
    this.rt = jade.core.Runtime.instance();
    Profile prof = new ProfileImpl();
    prof.setParameter(Profile.MAIN_HOST, host);
    prof.setParameter(Profile.MAIN_PORT, port);
    prof.setParameter(Profile.MAIN, "true");
    prof.setParameter(Profile.GUI, "true");
    this.container = rt.createMainContainer(prof);
    rt.setCloseVM(true);
    
    }

    public void startAgentInPlatform(String name, String classpath){
    try {
    AgentController ac = container.createNewAgent(
    name,
    classpath,
    new Object[0]);
    ac.start();
    } catch (Exception e) {
    e.printStackTrace();
    }
    }

    public static void main(String args[]) {
    Main mc = new Main();
    mc.initMainContainer("127.0.0.1", "6666");
    mc.startAgentInPlatform("login","Agents.Interface");
   
    }
    
     
  
    
}
*/
    
}