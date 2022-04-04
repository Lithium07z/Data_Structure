
public class Main {
	public static void main(String[] args) {
		DList<String> dl1 = new DList<String>();
		DList<String> dl2 = new DList<String>();
		DNode h1 = dl1.head;
		DNode h2 = dl2.head;
		
		for (int i = 0; i < 3; i++) {
			dl1.insertAfter(h1, i + 1);
			h1 = h1.getNext();
		}
		for (int i = 6; i < 10; i++) {
			dl2.insertAfter(h2, i);
			h2 = h2.getNext();
		}
		
		System.out.println("[DListTask1]");
		dl1.print();
		System.out.println("[DListTask2]");
		dl2.print();
		System.out.println("[DListTask3]");
		int add1 = dl1.add(dl2); 
		int add2 = dl2.add(dl1);
		System.out.println(add1);
		System.out.println(add2);
	}
}
