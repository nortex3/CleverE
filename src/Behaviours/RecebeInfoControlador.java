/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviours;
import Agents.Interface;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author NMVC
 */


public class RecebeInfoControlador extends CyclicBehaviour{
    
    private Interface inter;
    
    public RecebeInfoControlador(Interface i) {
        this.inter = i;
    }
    
    @Override
    public void action() {
        
        ACLMessage recebida = this.inter.receive();
        
        if (recebida != null) {
            if (recebida.getPerformative() == ACLMessage.INFORM) {
                if (recebida.getContent().matches("evento:.+")){
                    String[] eventos = recebida.getContent().split(":");
                    //for(String ss : eventos[1].split(";"))
                        //processa a mensagem    
                        System.out.println(eventos[1]);
                        }
            } else {System.out.println(recebida.getSender().getLocalName() + " -> " + recebida.getContent());
                System.out.println("Interface: Recebi mensagem que não me interessa");
            }
        }
        block();
    }
    
}
