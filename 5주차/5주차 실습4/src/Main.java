
public class Main {
	public static void main(String[] args) {
		SList<String> s1 = new SList<String>();
		SList<String> s2 = new SList<String>();
		SList<String> s3 = new SList<String>();
		
		int arr1[] = {7, 11, 4, 1, 8};
		int arr2[] = {5, 2, 8, 7, 13};
		for (int i = 5; i > 0; i--) {
			s3.insertFront(i);
		}
		
		System.out.println("[Task1]");
		s1.setAndOrderNodes(arr1);
		s1.print();
		
		System.out.println("[Task2]");
		s2.setAndOrderNodes(arr2);
		s2.print();
		
		System.out.println("[Task3]");
		s1.join(s2);
		s1.print();
		
		System.out.println("[ReverseTask1]");
		s3.print();
		System.out.println("[ReverseTask2]");
		s3.reverse();
		s3.print();
	}
}
