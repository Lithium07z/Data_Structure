
public class Main {
	public static void main(String[] args) {
		DoubleHashing DHashing = new DoubleHashing();
		
		DHashing.put(25, "grape");
		DHashing.put(37, "apple");
		DHashing.put(18, "banana");
		DHashing.put(55, "cherry");
		DHashing.put(22, "mango");
		DHashing.put(35, "lime");
		DHashing.put(50, "orange");
		DHashing.put(63, "watermelon");
		
		System.out.println("Ž�� ��� : ");
		System.out.println(50 + "�� data = " + DHashing.get(50));
		System.out.println(63 + "�� data = " + DHashing.get(63));
		DHashing.print();

	}
}
