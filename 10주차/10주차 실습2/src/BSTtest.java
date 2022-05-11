import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BSTtest {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		BST bst2 = new BST<Integer, Integer>(10, 10);

		bst2.put(60, 60);
		bst2.put(25, 25);
		bst2.put(30, 30);
		bst2.put(20, 20);
		bst2.put(50, 50);
		bst2.put(45, 45);
		bst2.put(70, 70);
		bst2.put(40, 40);
		bst2.put(35, 35);

		bst2.print(); // 삭제 전 출력
		bst2.deleteMax(); // 삭제 1
		System.out.println();
		bst2.print();
		bst2.deleteMax(); // 삭제 2
		System.out.println();
		bst2.print();
		bst2.deleteMax(); // 삭제 3
		System.out.println();
		bst2.print();
	}
}