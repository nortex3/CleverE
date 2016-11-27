/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviours;
import Agents.Controlador;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
/**
 *
 * @author NMVC
 */
public class EnviaEvento extends OneShotBehaviour{
    
    private Controlador cont;
    String mens;
    
    public EnviaEvento (Controlador c, String mensagem)  {
        this.cont = c;
        this.mens = mensagem;
    }
    
    @Override
    public void action() {
        String conteudo="evento:";
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        ACLMessage resp = null;
        msg.setConversationId("");
        msg.setContent(this.mens);
        AID even = new AID();
        even.setLocalName("even");
        msg.addReceiver(even);
        
        this.cont.send(msg);
 
            resp = this.cont.blockingReceive(3000);
            if (resp != null && resp.getPerformative() == ACLMessage.INFORM) {
                if(resp.getContent()!= null) {
                    //System.out.println(resp.getSender().getLocalName() + " -> " + resp.getContent());
                    //conteudo += resp.getSender().getLocalName() + "," + resp.getContent() + ";";
                    conteudo+=resp.getContent();
                }
            }
        

        
        conteudo = conteudo.substring(0,conteudo.length()-1);

        ACLMessage nova = new ACLMessage(ACLMessage.INFORM);
        AID iefe = new AID();
        iefe.setLocalName("interface");
        nova.addReceiver(iefe);
        nova.setConversationId("");
        nova.setContent(conteudo);

        this.cont.send(nova);

    }
}