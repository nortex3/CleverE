/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviours;
import Agents.Interface;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
/**
 *
 * @author NMVC
 */
public class PedeEventos extends OneShotBehaviour{
    
    private Interface iface;

    public PedeEventos(Interface i) {
        this.iface = i;
    }

    @Override
    public void action() {

        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        AID controlador = new AID();
        controlador.setLocalName("controlador");

        msg.addReceiver(controlador);
        msg.setConversationId("");

        msg.setContent("evento:");

        this.iface.send(msg);


    }
    
}
