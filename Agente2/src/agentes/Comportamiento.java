package agentes;

import jade.core.behaviours.Behaviour;

public class Comportamiento extends Behaviour{
    @Override
    public void action() {
        System.out.println("Hola mundo soy un agente");
    }

    @Override
    public boolean done() {
        return true;
    }
}
