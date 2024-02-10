package exercise3;

class CoffeeMachine {
  private static CoffeeMachine machine;
  private int coffeeBeans;
  private int waterLevel;

  private CoffeeMachine() {
    this.coffeeBeans = 0;
    this.waterLevel = 0;
  }

  public static CoffeeMachine getInstance() {
    if (machine == null) {
      synchronized (CoffeeMachine.class) {
        if(machine == null) {
         machine = new CoffeeMachine(); 
        }
      }
      
    }
    return machine;
  }

  public synchronized void brewCoffee() {
    if (coffeeBeans >= 1 && waterLevel >= 1) {
      System.out.println("Coffee is brewing.");
      coffeeBeans--;
      waterLevel--;
      System.out.println("Coffee is ready.");
    } else {
      System.out.println("Not enough water and coffee beans.");
    }
  }

  public synchronized void refillCoffeeBeans(int amountOfCoffeeBeans) {
    coffeeBeans += amountOfCoffeeBeans;
    System.out.println("Coffee filled: " + coffeeBeans);
  }

  public synchronized void checkWater() {
    System.out.println("Current water level is: " + waterLevel);
  }

  public synchronized void fillWater(int waterAmount) {
    waterLevel += waterAmount;
    System.out.println("Water refilled, currrent water level is: " + waterLevel);
  }
}

public class CoffeeApp {

  public static void main(String[] args) {

 
      CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();

      int numThreads = 3;

      for (int i = 0; i < numThreads; i++) {
          Thread thread = new Thread(() -> {
              CoffeeMachine threadCoffeeMachine = CoffeeMachine.getInstance();
              threadCoffeeMachine.brewCoffee();
              threadCoffeeMachine.refillCoffeeBeans(4);
              threadCoffeeMachine.checkWater();
              threadCoffeeMachine.fillWater(3);
          });
          thread.start();
      }

  }

}
