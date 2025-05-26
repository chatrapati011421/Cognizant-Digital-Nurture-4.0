import java.util.Scanner;
import java.util.InputMismatchException;

public class EvenorOddChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter the integer: ");
            long num=sc.nextLong();
            if(num%2==0L){
            System.out.println("The number "+num+" is Even.");
            }
            else{
                System.out.println("The number "+num+" is Odd.");
            }
        }
        catch(InputMismatchException e){
            System.out.println("Error: Please enter a valid integer."+e);
        }
        sc.close();
    }
}
