/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviours;

import Agents.Interface;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Alexandre
 */
public class IniciaInterface extends ParallelBehaviour{
    private Interface i;
    
    public IniciaInterface(Interface i){
        //super(i);
        this.addSubBehaviour(new PedeEventos(i));
        this.addSubBehaviour(new RecebeInfoControlador(i));
       
        }
 }
 
 
    

