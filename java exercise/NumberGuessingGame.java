import java.util.*;

public class  NumberGuessingGame{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random random=new Random();
		int number=random.nextInt(101);
		int attempts=0;
		int guess;
		do{
		    System.out.println("Guess the number: ");
		    guess=sc.nextInt();
		    attempts++;
		    if (guess > number) {
                System.out.println("Too high! Try again.");
            } else if (guess < number) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }
        } while (guess != number);
		sc.close();
	}
}
