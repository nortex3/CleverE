/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviours;
import Agents.Interface;
import GUI.AfterLogin;
import GUI.ListaEventos;
import GUI.YellowPages;
import com.restfb.types.Event;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author NMVC
 */


public class RecebeInfoControlador extends CyclicBehaviour{
    
    private Interface inter;
    //private AfterLogin aft;
    
    public RecebeInfoControlador(Interface i) {
        this.inter = i;
    }
    
    @Override
    public void action() {
        
        ACLMessage recebida = this.inter.receive();
        
        if (recebida != null) {
            Object eventos = new ArrayList<Event>();
            if (recebida.getPerformative() == ACLMessage.INFORM) {
                //if (recebida.getContent().matches("evento:*")){
                    System.out.println("ENTREI");
                   
                try {
                    eventos =  recebida.getContentObject();
                    System.out.println("XXXXXXXXXXX\n" + eventos.toString());
                } catch (UnreadableException ex) {
                    Logger.getLogger(RecebeInfoControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                    ListaEventos le = new ListaEventos();
                    le.setVisible(true);
                    le.mostraEventos((List<Event>) eventos);
                   
                    //for(String ss : eventos[1].split(";"))
                        //processa a mensagem 
                        
                    AID receiver = new AID();
                    receiver.setLocalName("controlador");
                    long time = System.currentTimeMillis();
                    ACLMessage accept = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                    accept.setContent("recebi");
                    accept.setConversationId(""+time);
                    accept.addReceiver(receiver);
                    this.inter.send(accept);
                    System.out.println("RECEBI UM EVENTO DO CONTROLADOR");
                        //}
                 if(recebida.getContent().matches("agentes:.+")){
                    System.out.println("RECEBI INFORMAÇÃO DO CONTROLADOR");
                    List<String> agentes = new ArrayList<String>(Arrays.asList(recebida.getContent().split(":")));
                    //for(String ss: agentes[1].split(";")){
                        YellowPages yp = new YellowPages();
                        yp.setVisible(true);
                        yp.mostraAgentes(agentes);
                        //System.out.println(agentes);
                        //AfterLogin aft = new AfterLogin();
                        //aft.mostraAgentes(agentes);
                        //aft.mostra(agentes);
                        
                    AID receiver2 = new AID();
                    receiver2.setLocalName("controlador");
                    //long time = System.currentTimeMillis();
                    ACLMessage accept2 = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                    accept.setContent("recebi");
                    accept.setConversationId(""+time);
                    accept.addReceiver(receiver);
                    this.inter.send(accept);
                        
                        
                        //System.out.println(ss);
                    //}
                }
            } else if(recebida.getPerformative() == ACLMessage.NOT_UNDERSTOOD){
                AfterLogin af = new AfterLogin();
                af.mostraOptionPane();
                //System.out.println(recebida.getSender().getLocalName() + " -> " + recebida.getContent());
                //System.out.println("Interface: Recebi mensagem que não me interessa");
            }
        }
        block();
    }
    
}
