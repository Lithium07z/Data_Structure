
public class Main {
	public static void main(String[] args) {
		Chaining chain = new Chaining();
		
		chain.put(25, "grape");
		chain.put(37, "apple");
		chain.put(18, "banana");
		chain.put(55, "cherry");
		chain.put(22, "mango");
		chain.put(35, "lime");
		chain.put(50, "orange");
		chain.put(63, "watermelon");
		
		System.out.println("Ž�� ���");
		System.out.println("50�� data = " + chain.get(50));
		System.out.println("63�� data = " + chain.get(63));
		System.out.println("37�� data = " + chain.get(37));
		System.out.println("22�� data = " + chain.get(22));
		
		chain.print();
	}
}
