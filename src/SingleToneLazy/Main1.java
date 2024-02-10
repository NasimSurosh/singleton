package SingleToneLazy;

/*
 *   singleton means a class can have only one instance.
 *   
 *   lazy singletone
 */

class Car1 {
  static Car1 car; // step 1

  private Car1() { // step 2
    System.out.println("Instance created.");

  }

  public static Car1 getInstance() { // step 3
    if (car == null) { // double-checked locking mechanism
      synchronized (Car1.class) {
        if (car == null)
          car = new Car1();
      }
    }

    return car;
  }
}

public class Main1 {

  public static void main(String[] args) {

    Thread thread1 = new Thread(new Runnable() {

      @Override
      public void run() {
        Car1 car1 = Car1.getInstance();
      }

    });

    Thread thread2 = new Thread(new Runnable() {

      @Override
      public void run() {
        Car1 car2 = Car1.getInstance();

      }

    });

    thread1.start();
    thread2.start();

  }

}
