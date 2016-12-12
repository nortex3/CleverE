
package Behaviours;

import Agents.Controlador;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



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
            System.out.println("A MENSAGEM NAO ESTA NULA");
            System.out.println(mensagem);
            if(mensagem.getPerformative() == ACLMessage.REQUEST){
               
                    System.out.println(mensagem.getContent());
               
                
                /*else{
                AID receiver = new AID();
                receiver.setLocalName("inter");
                long time = System.currentTimeMillis();
                ACLMessage accept = new ACLMessage(ACLMessage.NOT_UNDERSTOOD);
                accept.setContent("Não entendi");
                accept.setConversationId(""+time);
                accept.addReceiver(receiver);
                this.cont.send(accept);
                }*/
                String Utilizador = (String) mensagem.getContent();
                String[] parts = Utilizador.split(":");
                this.cont.setMensagem(parts[0]);
                this.cont.setChuva(parts[1]);
                this.cont.setTempMax(parts[2]);
                this.cont.setTempMin(parts[3]);
                System.out.println(this.cont.getMensagem()+" "+this.cont.getChuva()+" "+this.cont.getTempMax()+" "+this.cont.getTempMin());
                //mensagem = this.cont.blockingReceive(3000);
                if(this.cont.getMensagem().equals("daAgentes")){
                    new DaAgentesBehaviour(this.cont).action();
                    block();
                }
                else if(this.cont.getMensagem().equals("braga")){
                    System.out.println("SOU O CONTROLADOR " + "VEM DE " +mensagem.getSender().getLocalName() + " -> " + mensagem.getContent());
                    String mens=this.cont.getMensagem();
                    new EnviaEvento(this.cont,mens).action();
                    block();
                } else{
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
