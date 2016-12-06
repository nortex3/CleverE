
package Behaviours;

import Agents.Controlador;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;



public class RecebePedidosInterface extends CyclicBehaviour {
    private Controlador cont;
    
    public RecebePedidosInterface (Controlador c)  {
        this.cont = c;
    }

    @Override
    public void action() {
        ACLMessage mensagem = this.cont.receive();
        //System.out.println("Entrei aqui");
        //if(mensagem == null){
          //  System.out.println("Nao tem nada");
        //}
        if(mensagem != null){
            if(mensagem.getPerformative() == ACLMessage.REQUEST){
                
                if(mensagem.getContent().equals("braga")){
                    System.out.println("SOU O CONTROLADOR " + "VEM DE " +mensagem.getSender().getLocalName() + " -> " + mensagem.getContent());
                    String mens=mensagem.getContent();
                    new EnviaEvento(this.cont,mens).action();
                    block();
                }
               
            
            
            else {
                    AID receiver = new AID();
                    receiver.setLocalName("inter");
                    long time = System.currentTimeMillis();
                    ACLMessage accept = new ACLMessage(ACLMessage.NOT_UNDERSTOOD);
                    accept.setContent("Não entendi");
                    accept.setConversationId(""+time);
                    accept.addReceiver(receiver);
                    this.cont.send(accept);
            }
        }

        }
    }
}
