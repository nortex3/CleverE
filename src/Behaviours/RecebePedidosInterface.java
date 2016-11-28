
package Behaviours;

import Agents.Controlador;
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
        if(mensagem != null){
            if(mensagem.getPerformative() == ACLMessage.REQUEST){
                
                if(mensagem.getContent().equals("evento:")){
                    //System.out.println(mensagem.getSender().getLocalName() + " -> " + mensagem.getContent());
                    String mens=mensagem.getContent();
                    new EnviaEvento(this.cont,mens).action();
                    block();
                }
               
            }
            else {
                //qualquer cena
            }
        }

    }
    
}
