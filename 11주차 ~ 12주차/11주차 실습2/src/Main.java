
public class Main {
	public static void main(String[] args) {
		QuadProbing QProbing = new QuadProbing();
		
		QProbing.put(25, "grape");
		QProbing.put(37, "apple");
		QProbing.put(18, "banana");
		QProbing.put(55, "cherry");
		QProbing.put(22, "mango");
		QProbing.put(35, "lime");
		QProbing.put(50, "orange");
		QProbing.put(63, "watermelon");
		
		System.out.println("탐색 결과 : ");
		System.out.println(50 + "의 data = " + QProbing.get(50));
		System.out.println(63 + "의 data = " + QProbing.get(63));
		QProbing.print();
		
	}
}
