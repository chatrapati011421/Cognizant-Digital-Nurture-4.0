import java.util.Scanner;
class Car{
    String make;
    String model;
    int year;
    Car(String make,String model,int year){
        this.make=make;
        this.model=model;
        this.year=year;
    }
    public void displayDetails(){
        System.out.println("Make: "+make);
        System.out.println("Model: "+model);
        System.out.println("Year: "+year);
        System.out.println();
    }
}
public class ClassandObjectCreation {
    public static void main(String[] args) {
        Car c1=new Car("Tayota","Corolla",1980);
        Car c2=new Car("Tata","nano",2018);
        Car c3=new Car("Audi","SUV",1980);
        c1.displayDetails();
        c2.displayDetails();
        c3.displayDetails();
    }
}
