package Books.agents;

import Books.behaviours.RequestPerformer;
import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import Books.gui.BookBuyerGui;

public class BookBuyerAgent extends Agent {
  private String bookTitle;
  private AID[] sellerAgents;
  private final int ticker_timer = 10000;
  private BookBuyerAgent this_agent = this;
  private BookBuyerGui gui;
  
  protected void setup() {
    System.out.println("Buyer agent " + getAID().getName() + " is ready");
    gui = new BookBuyerGui(this);
    gui.showGui();
    
    Object[] args = getArguments();
    if(args != null && args.length > 0) {
      bookTitle = args[0].toString();
      System.out.println("Book: " + bookTitle);
      gui.setTitulo(bookTitle);
      
      addBehaviour(new TickerBehaviour(this, ticker_timer) {
        protected void onTick() {
          System.out.println("Intentando comprar " + bookTitle);
          gui.setResult("Intentando comprar " + bookTitle);
          
          DFAgentDescription template = new DFAgentDescription();
          ServiceDescription sd = new ServiceDescription();
          sd.setType("book-selling");
          template.addServices(sd);
          
          try {
            DFAgentDescription[] result = DFService.search(myAgent, template);
            System.out.println("Encontrados los siguientes vendedores:");
            gui.setResult("\nEncontrados los siguientes vendedores:");
            sellerAgents = new AID[result.length];
            for(int i = 0; i < result.length; i++) {
              sellerAgents[i] = result[i].getName();
              System.out.println(sellerAgents[i].getName());
              gui.setResult("\n"+sellerAgents[i].getName());
            }
            
          }catch(FIPAException fe) {
            fe.printStackTrace();
          }
          myAgent.addBehaviour(new RequestPerformer(this_agent));
        }
      });
    } else {
      System.out.println("No se especifica el nombre del libro");
      gui.setResult("\nNo se especifica el nombre del libro");
      doDelete();
    }
  }
  
  protected void takeDown() {
    System.out.println("Agente comprador " + getAID().getName() + " terminado");
  }
  
  public AID[] getSellerAgents() {
    return sellerAgents;
  }
  
  public String getBookTitle() {
    return bookTitle;
  }
}
