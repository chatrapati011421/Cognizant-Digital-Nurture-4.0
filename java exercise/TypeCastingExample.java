public class  TypeCastingExample {
	public static void main(String[] args) {
		double w = 72.5;
		int w1 = (int)w;
		System.out.println("Type Casting from double to int : "+w1);
		System.out.println("Type of w: " + ((Object)w).getClass().getName());
		System.out.println("Type of w1: " + ((Object)w1).getClass().getName());
		int h=120;
		double h1=h;
		System.out.println();
		System.out.println("Type Casting from int to double: "+h1);
		System.out.println("Type of w1: " + ((Object)h).getClass().getName());
		System.out.println("Type of w1: " + ((Object)h1).getClass().getName());
	}
}
