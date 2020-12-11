import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

/**
 *
 * @author areli
 */
public class EjemWaker extends Agent
{
    protected void setup()
    {
        System.out.println("Añadir comportamiento Wake");
        addBehaviour (new WakerBehaviour (this, 10000)
                {
                    protected void onWake()
                    {
                        System.out.println("Pasaron 10 segundos");
                    }
                });
    }
}
