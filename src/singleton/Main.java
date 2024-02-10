package singleton;  
/*
 *   singleton means a class can have only one instance.
 */
             
class Car{
  static Car car = new Car();   // step 1
  private Car() {               // step 2
    System.out.println("Instance created.");
  }
  public static Car getInstance() {     //step 3
    return car;
  }
}
public class Main {

  public static void main(String[] args) {
    
    Car car1 = Car.getInstance();
    Car car2 = Car.getInstance();
    

  }

}
