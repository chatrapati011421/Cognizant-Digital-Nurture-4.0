import java.util.Scanner;
class Animal{
    public static void makeSound(){
        System.out.println("The animal Sounds.");
    }
}
class Dog extends Animal{
    public static void makeSound(){
        System.out.println("Bark");
    }
}
public class InheritanceExample {
    public static void main(String[] args) {
        Animal animal=new Animal();
        System.out.println("Animal sound:");
        animal.makeSound();
        Dog dog=new Dog();
        System.out.println();
        System.out.println("Dog Sound: ");
        dog.makeSound();
    }
}
