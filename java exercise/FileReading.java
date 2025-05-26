import java.io.IOException;
import java.io.FileReader;
import java.io.*;

public class FileReading {
	public static void main(String[] args) {

		try {
			BufferedReader br= new BufferedReader(new FileReader("C:\\Users\\chatr\\OneDrive\\Desktop\\dn 4.0 exersice\\output.txt"));
			String line;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
            br.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
