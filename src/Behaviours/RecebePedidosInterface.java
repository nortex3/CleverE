
package Behaviours;

import Agents.Controlador;
import jade.core.behaviours.CyclicBehaviour;



public class RecebePedidosInterface extends CyclicBehaviour {
    private Controlador cont;
    
    public RecebePedidosInterface (Controlador c)  {
        this.cont = c;
    }

    @Override
    public void action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
