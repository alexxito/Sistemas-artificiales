package agentes;

import jade.core.behaviours.Behaviour;

public class Comportamiento extends Behaviour {
    int contador = -1;
    @Override
    public void action() {
        contador++;
        System.out.println(contador);
    }

    @Override
    public boolean done() {
        if(contador == 100){
            return true;
        }
        else {
            return false;
        }
    }
}
