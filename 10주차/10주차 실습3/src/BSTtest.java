import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BSTtest {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		BST bst3 = new BST<Integer, Integer>(10, 10);

		bst3.put(60, 60);
		bst3.put(25, 25);
		bst3.put(30, 30);
		bst3.put(20, 20);
		bst3.put(50, 50);
		bst3.put(45, 45);
		bst3.put(70, 70);
		bst3.put(40, 40);
		bst3.put(35, 35);
		
		for (int i = 0; i < 5; i++) {
			System.out.println(i + "th Smallest : " + bst3.kthSmallest(i));
		}
	}
}