package exercise2;



class ChocolateBoiler{
  
  private static ChocolateBoiler chocolateBoiler;
  private boolean empty;
  private boolean boiled;
  
  private ChocolateBoiler() {
  
    empty = true;
    boiled = false;
  }
  public static synchronized ChocolateBoiler getInstance() {
    if(chocolateBoiler == null) {
      chocolateBoiler = new ChocolateBoiler();
    }
    return chocolateBoiler;
  }
  public void filling() {
    if(isEmpty()) {
      empty = false;
      boiled = false;     
      System.out.println("Fill the chocolate boiler.");
    }else {
      System.out.println("The boiler is already full.");
    }
  }
  public void boiling() {
    if(isEmpty() && isBoiled()) {
      boiled = true;
      System.out.println("Chocolate boiler is boiling.");
      }else if(isEmpty()){
        System.out.println("Fill the boiler, the boiler is empty");
      }else {
        System.out.println("The boiler is already boiled.");
      }
    }
  public void draining() {
    if(!isEmpty() && isBoiled()) {
      empty = true;
      System.out.println("Cocolate is draining.");
    }else if(isEmpty()) {
      System.out.println("Boiler is empty.");
    }else {
      System.out.println("Draining boiled chocolate.");
    }
  }
  private boolean isEmpty() {
    // TODO Auto-generated method stub
    return false;
  }
  private boolean isBoiled() {
    // TODO Auto-generated method stub
    return false;
  }
}

public class ChocolateApp {

  public static void main(String[] args) {
    
   Runnable chocolateSituation = ()->{
     ChocolateBoiler situation = ChocolateBoiler.getInstance();
     situation.filling();
     situation.boiling();
     situation.draining();
   };
    Thread thread1 = new Thread(chocolateSituation);
    Thread thread2 = new Thread(chocolateSituation);
    Thread thread3 = new Thread(chocolateSituation);
    
    thread1.start();
    thread2.start();
    thread3.start();
 
  }

}
