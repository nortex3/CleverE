/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents;
import Business.UserData;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
/**
 *
 * @author Miguel
 */
public class Eventos extends Agent{
    
     protected void setup() {
        super.setup();
        System.out.println("Agente " + this.getLocalName() + " a iniciar...");
        this.addBehaviour(new ReceiveBehaviour());
    }
     
    protected void takeDown(){
        super.takeDown();
        System.out.println(this.getLocalName()+" a morrer...");
    }

    private class ReceiveBehaviour extends CyclicBehaviour {

        @Override
        public void action() {
            ACLMessage msg = receive();
            String str="";
            if (msg != null) {
                ACLMessage reply = msg.createReply();
                
                if (msg.getPerformative() == ACLMessage.REQUEST) {
                    if (msg.getContent().equals("evento:")) {
                        //UserData userdata = new UserData();

                        //str+=userdata.getFbclient(); 
                        str+="Temos de acreditar que o FCP vai ser campeao!!! ";
                        //str+=//gets
                        reply.setContent(str);
                        reply.setPerformative(ACLMessage.INFORM);
                        myAgent.send(reply);
                        }
                } else {
                    reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                    myAgent.send(reply);
                }
            }
            block();
        }
    }
}
