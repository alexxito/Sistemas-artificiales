package agentes;

import jade.core.Agent;

public class Agente extends Agent {
    Comportamiento comp = new Comportamiento();
    protected void setup() {
        this.addBehaviour(comp);
    }
}
