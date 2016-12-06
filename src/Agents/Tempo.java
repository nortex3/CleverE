/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

/**
 *
 * @author Miguel
 */
public class Tempo extends Agent {
    
    protected void setup() {
        super.setup();
        
        DFAgentDescription dfs = new DFAgentDescription();
        dfs.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setName(getLocalName());
        
        sd.setType("agentes");
        dfs.addServices(sd);
        
        try{
            DFService.register(this, dfs);
        } catch(FIPAException e){
            e.printStackTrace();
        }
        
        System.out.println("Agente " + this.getLocalName() + " a iniciar...");
    }
    
     protected void takeDown(){
        super.takeDown();
        
        try{
            DFService.deregister(this);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(this.getLocalName()+" a morrer...");
    }
    
}
