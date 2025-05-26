import java.util.Scanner;
interface Playable{
    void play();
}
class Guitar implements Playable{
    public void play(){
        System.out.println("Guitar is playing.");
    }
}
class Piano implements Playable{
    public void play(){
        System.out.println("Piano is playing");
    }
}
public class InterfaceImplementation {
    public static void main(String[] args) {
       Playable g=new Guitar();
       g.play();
       System.out.println();
       Piano p=new Piano();
       p.play();
    }
}
