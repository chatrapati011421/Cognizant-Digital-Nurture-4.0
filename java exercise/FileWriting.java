package hello;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class FileWriting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to write in the file:");
        String s = sc.nextLine();

        try {
            FileWriter writer = new FileWriter("C:\\Users\\chatr\\OneDrive\\Desktop\\dn 4.0 exersice\\output.txt", true);
            writer.write(s + "\n");
            writer.close();
            System.out.println("Data has been written to the output.txt file");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
