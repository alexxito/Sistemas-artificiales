package agentes;

import jade.core.Agent;

public class Agente extends Agent {
    protected void setup(){
        Comportamiento comp = new Comportamiento();
        this.addBehaviour(comp);
    }
}
