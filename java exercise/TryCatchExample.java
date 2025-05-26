import java.util.Scanner;
public class TryCatchExample  {
    public static void main(String[] args) {
        int[] arr=new int[2];
        try{
            arr[1]=29;
            arr[2]=10;
            arr[0]=20;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}
