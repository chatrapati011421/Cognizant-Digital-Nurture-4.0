import java.util.*;
import java.math.BigInteger;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Please enter a non-negative integer.");
            return;
        }

        BigInteger fact = BigInteger.ONE; 

        for (int i = 2; i <= num; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        System.out.println("The factorial of " + num + " is: " + fact);
        sc.close();
    }
}
