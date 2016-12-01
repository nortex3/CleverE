/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents;

//import authuser.login;


import Behaviours.IniciaInterface;
import Behaviours.RecebeInfoControlador;
import GUI.AfterLogin;
import GUI.Login;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Event;
import com.restfb.types.User;
import jade.core.AID;

import jade.core.Agent;
import jade.gui.GuiAgent;
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





public class Interface extends GuiAgent {
    
    protected Login myGui;
    
    private FacebookClient fbClient;
    // private ArrayList<String> ListaEventos;
    
     public Interface(){
        this.fbClient = new DefaultFacebookClient();
        // this.ListaEventos = new ArrayList<>();
    }
     
    
    @Override
    protected void setup() {
        myGui = new Login(this);
        System.out.println("Interface a iniciar..");
        myGui.setVisible(true);
        
        super.setup();
        
        //adicionar behaviours aqui
        //this.addBehaviour(new IniciaInterface(this));
        this.addBehaviour(new RecebeInfoControlador(this));
       
       
    }
    
    protected void onGuiEvent(GuiEvent ev){
        int comand= ev.getType();
        System.out.println("vou entrar no if");
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
        System.out.println("passei pelo if");
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
    
 
    
    
    
}
