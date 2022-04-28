
public class Main {
	public static void main(String[] args) {
		ArrayQueue<Object> queue1 = new ArrayQueue<Object>();
		ArrayQueue<Object> queue2 = new ArrayQueue<Object>();
		ArrayQueue<Object> queue3 = new ArrayQueue<Object>();
		
		for (int i = 1; i < 6; i++) {
			queue1.add(i);
		}

		System.out.println("[Q3. Task 1]");
		queue1.print();
		System.out.println(queue1.avg());
		queue1.print();

		System.out.println("[Q4. Task1]");
		queue2.add("A");  queue2.add("B");
		queue2.add("C");  queue2.add("D");
		queue2.add("E");
		queue2.print();
		queue2.reverse();
		queue2.print();
		
		System.out.println("[Q4. Task2]");
		for (int i = 5; i > 0; i--) {
			queue3.add(i);
		}
		queue3.print();
		queue3.reverse();;
		queue3.print();
		
		
	}
}
