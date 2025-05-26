import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);
        String reversed1 = sb.reverse().toString();
        System.out.println("Reversed using StringBuilder: " + reversed1);

        String reversed2 = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed2 += input.charAt(i);
        }
        System.out.println("Reversed using loop: " + reversed2);

        sc.close();
    }
}
