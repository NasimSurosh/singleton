package exercise;

class SingletonExample {

  private static SingletonExample instance;
  private String message;

  private SingletonExample() {
    message = "Single instance";
  }

  public static SingletonExample getInstance() {
    if (instance == null) {
      instance = new SingletonExample();
    }
    return instance;

  }

  public void displayMessage() {
    System.out.println(message);
  }
}

public class SingletonClient {

  public static void main(String[] args) {

    SingletonExample example1 = SingletonExample.getInstance();
    SingletonExample example2 = SingletonExample.getInstance();

    example1.displayMessage();
    example2.displayMessage();

    if (example1 == example2) {
      System.out.println("Both instance refer to the same singletone instance");
    } else {
      System.out.println("Error: Multiple instance detected.");
    }

  }

}
