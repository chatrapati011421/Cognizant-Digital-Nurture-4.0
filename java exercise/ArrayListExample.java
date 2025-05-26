import java.util.*;

public class ArrayListExample {
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> arr=new ArrayList<>();
        int enter=1;
        while(enter==1){
        System.out.println("Enter the name: ");
        String s=sc.nextLine();
        arr.add(s);
        System.out.println("Do you wnr to enter another name if Yes type 1 or No type 0: ");
        enter = sc.nextInt();
        sc.nextLine();
        }
        sc.close();
	}
}
