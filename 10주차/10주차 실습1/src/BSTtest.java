import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BSTtest {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		BST bst1 = new BST<Integer, Integer>(10, 10);

		bst1.put(60, 60);
		bst1.put(25, 25);
		bst1.put(30, 30);
		bst1.put(20, 20);
		bst1.put(50, 50);
		bst1.put(45, 45);
		bst1.put(70, 70);
		bst1.put(40, 40);
		bst1.put(35, 35);

		bst1.print();
		System.out.println();
		System.out.println("Searching for 45 yields : " + bst1.get(45));
		bst1.put(45, 99);
		System.out.println("Searching for 45 yields : " + bst1.get(45));
		System.out.println("Min value : " + bst1.min());
		bst1.deleteMin();
		System.out.println("Min value : " + bst1.min());
		bst1.delete(25);
		bst1.delete(35);
		bst1.delete(45);
		bst1.print();
	}
}
