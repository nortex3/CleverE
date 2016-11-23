/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents;

import authuser.login;


import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Event;
import com.restfb.types.User;

import jade.core.Agent;
import java.util.ArrayList;
import javafx.scene.control.ListView;

/**
 *
 * @author Miguel/Alexandre
 */
public class Interface extends Agent {
    

    private FacebookClient fbClient;
    private ListView<String> ListaEventos;
    
     public Interface(){
        // this.fbClient = new login.authUser();
        this.ListaEventos = new ListView<>();
    }
     
    
    protected void setup() {
        super.setup();
        //adicionar behaviours aqui
        //this.addBehaviour(new IniciaInterface(this));
       
        System.out.println("Interface a iniciar..");
    }
    
 
    
    
    
}
