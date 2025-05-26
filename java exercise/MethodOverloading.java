public class MethodOverloading {
    public static int add(int a,int b){
        return a+b;
    }
    public static double add(double a,double b){
        return a+b;
    }
    
    public static int add(int a,int b,int c){
        return a+b+c;
    }
    public static void main(String[] args) {
        System.out.println("Method Overloading");
        System.out.println(add(2,4));
        System.out.println(add(3.5,4.7));
        System.out.println(add(2,5,8));
    }
}
