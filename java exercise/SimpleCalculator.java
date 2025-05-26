import java.util.Scanner;
import java.util.InputMismatchException;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Choose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        int choice = 0;
        boolean validInput = true;

        try {
            System.out.print("Enter your choice (1/2/3/4): ");
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer for the operation.");
            validInput = false;
        }

        double result = 0;
        boolean validOperation = true;

        if (validInput) {
            switch (choice) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        validOperation = false;
                        System.out.println("Error: Division by zero.");
                    }
                    break;
                default:
                    validOperation = false;
                    System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
            }
        } else {
            validOperation = false;
        }

        scanner.close();

        if (validInput && validOperation) {
            System.out.println("Result: " + result);
        }
    }
}
