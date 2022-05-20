
public class Main {
	public static void main(String[] args) {
		RandProbing RandProbing = new RandProbing();
		
		RandProbing.put(25, "grape");
		RandProbing.put(37, "apple");
		RandProbing.put(18, "banana");
		RandProbing.put(55, "cherry");
		RandProbing.put(22, "mango");
		RandProbing.put(35, "lime");
		RandProbing.put(50, "orange");
		RandProbing.put(63, "watermelon");
		
		System.out.println("탐색 결과 : ");
		System.out.println(50 + "의 data = " + RandProbing.get(50));
		System.out.println(63 + "의 data = " + RandProbing.get(63));
		RandProbing.print();

	}
}
