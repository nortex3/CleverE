/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents;

//import authuser.login;


import Behaviours.IniciaInterface;
import GUI.AfterLogin;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Event;
import com.restfb.types.User;
import jade.core.AID;

import jade.core.Agent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 *
 * @author Miguel/Alexandre
 */





public class Interface extends Agent {
    
    protected AfterLogin myGui;
    
    private FacebookClient fbClient;
    // private ArrayList<String> ListaEventos;
    
     public Interface(){
        this.fbClient = new DefaultFacebookClient();
        // this.ListaEventos = new ArrayList<>();
    }
     
    
    @Override
    protected void setup() {
        //myGui = new AfterLogin(this);
        //myGui.frame.setVisible(true);
        
        super.setup();
        //adicionar behaviours aqui
        this.addBehaviour(new IniciaInterface(this));
       
        System.out.println("Interface a iniciar..");
    }
    
    protected void onGuiEvent(GuiEvent ev){
        int comand= ev.getType();
        
        if(comand==1){
            String content = (String)ev.getSource();
            AID receiver = new AID();
            receiver.setLocalName("controlador");
            long time = System.currentTimeMillis();
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
            msg.setContent(content);
            msg.setConversationId(""+time);
            msg.addReceiver(receiver);
            send(msg);
        }
    }
	
    
    protected void takeDown() {
        super.takeDown(); //To change body of generated methods, choose Tools | Templates.
            System.out.println("Interface a terminar..");
    }
    
    public void setFbClient(FacebookClient client){
        this.fbClient = client;
    }
    
    public FacebookClient getFbClient(){
        return this.fbClient;
    }
    
 
    public void postGuiEvent(GuiEvent ge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
