/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviours;
import Agents.Interface;
import GUI.AfterLogin;
import GUI.YellowPages;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;

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
                    //String[] eventos = recebida.getContent().split(":");
                    //for(String ss : eventos[1].split(";"))
                        //processa a mensagem    
                        System.out.println("RECEBI UM EVENTO DO CONTROLADOR");
                        }
                else if(recebida.getContent().matches("agentes:.+")){
                    System.out.println("RECEBI INFORMAÇÃO DO CONTROLADOR");
                    List<String> agentes = new ArrayList<String>(Arrays.asList(recebida.getContent().split(":")));
                    //for(String ss: agentes[1].split(";")){
<<<<<<< HEAD
                        YellowPages yp = new YellowPages();
                        yp.setVisible(true);
                        yp.mostraAgentes(agentes);
=======
                        AfterLogin af = new AfterLogin();
                        af.setVisible(true);
                        af.mostraAgentes(agentes);
                  
                     
>>>>>>> origin/master
                        //System.out.println(agentes);
                        //AfterLogin aft = new AfterLogin();
                        //aft.mostraAgentes(agentes);
                        //aft.mostra(agentes);
                        
                        
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
