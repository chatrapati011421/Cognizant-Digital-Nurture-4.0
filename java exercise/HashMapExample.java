import java.util.*;

public class HashMapExample {
	public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int enter =1;
        while(enter==1) {
            System.out.print("Enter Student ID (integer): ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            studentMap.put(id, name);
            System.out.println("Do you want enter another name: type 1(if Yes): ");
            enter = sc.nextInt();
            sc.nextLine();
        }
        
        
        System.out.print("Enter an ID to search for: ");
        int searchId = sc.nextInt();
        if (studentMap.containsKey(searchId)) {
            System.out.println("Student Name: " + studentMap.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }

        sc.close();
	}
}
