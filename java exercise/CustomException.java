import java.util.Scanner;
class InvalidAgeException extends Exception{
    public InvalidAgeException(String m){
        super(m);
    }
}
public class CustomException{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the age: ");
        short age=sc.nextShort();
        try{
            checkage(age);
            System.out.println("Access granted.");
        }
        catch(InvalidAgeException e){
            System.out.println("Exception caught: "+e.getMessage());
        }
        sc.close();
    }
    public static void checkage(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age must be 18 or above.");
        }
    }
}
