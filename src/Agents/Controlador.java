/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.RecebePedidosInterface;
import jade.core.Agent;


public class Controlador extends Agent {
    
    @Override
    protected void setup() {
        
        super.setup();
        System.out.println("Controlador a iniciar..");
        this.addBehaviour(new RecebePedidosInterface(this));
    }
    
    @Override
    protected void takeDown(){
        super.takeDown();
        System.out.println(this.getLocalName()+" a morrer...");
    }
}
