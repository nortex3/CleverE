/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents;
import Business.UserData;
import GUI.AfterLogin;
import com.restfb.DefaultFacebookClient;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
/**
 *
 * @author Miguel
 */
public class Eventos extends Agent{
    
  
    
    
    UserData user = new UserData(AfterLogin.getFbclient());
    
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
        this.addBehaviour(new ReceiveBehaviour());
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
    

    private class ReceiveBehaviour extends CyclicBehaviour {

        @Override
        public void action() {
            ACLMessage msg = receive();
            String str="";
            if (msg != null) {
                ACLMessage reply = msg.createReply();
                
                if (msg.getPerformative() == ACLMessage.REQUEST) {
                    if (msg.getContent().equals("braga")) {
                        
                        if(user==null) System.out.println("user ta NULL");
                        str+=user.getMyEventList(); 
                        //System.out.println("deu");
                        //str+="RECEBI O PEDIDO DO CONTROLADOR ->>> A enviar evento: EVENTO BRAGA ";
                        //str+=//gets
                        reply.setContent(str);
                        reply.setPerformative(ACLMessage.INFORM);
                        myAgent.send(reply);
                        }
                } else if(msg.getPerformative() == ACLMessage.ACCEPT_PROPOSAL){
                          System.out.println("Tudo OK");}
                          else{
                    reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                    myAgent.send(reply);
                                  }
                
            }
            block();
        }
    }
}
