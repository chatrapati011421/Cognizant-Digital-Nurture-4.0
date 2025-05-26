import java.util.*;

public class RecursiveFibonacci {
    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Whole numbers: ");
        int n=sc.nextInt();
        if(n<0){
            System.out.println("Enter the valid Whole number.");
            return;
        }
        int sol=fibonacci(n);
        System.out.println(sol);
    }
}
