import java.util.*;

public class  GradeCalculator{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try{
		System.out.println("Enter the marks out of 100: ");
		byte marks=sc.nextByte();
		char grade;
		if(marks>=90 && marks<=100){
		    grade='A';
		}
		else if(marks<=89 && marks>=80){
		    grade='B';
		}
		else if(marks<=79 && marks>=70){
		    grade='C';
		}
		else if(marks<=69 && marks>=60){
		    grade='D';
		}
		else if(marks<=59 && marks>=0){
		    grade='F';
		}
		else{
		    System.out.println("Please enter the correct marks in range (0 to 100).");
		    return;
		}
		System.out.println("The Grade is: "+grade);
		}
		catch(InputMismatchException e){
		    System.out.println("Please enter the correct marks in range (0 to 100).");
		}
		sc.close();
	}
}
