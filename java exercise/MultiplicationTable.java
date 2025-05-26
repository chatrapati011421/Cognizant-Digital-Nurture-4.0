import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number upto (2,147,483,647): ");
        int n = sc.nextInt();

        for(int i=1;i<=10;i++){
            long result = (long) n * i;
            System.out.println(n+" * "+i+" = "+result);
        }
        sc.close();
    }
}
