import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BSTtest {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		BST bst4 = new BST<Integer, Integer>();
		BST bst5 = new BST<Integer, Integer>();
		
		Node node4_1 = new Node(50, 50);
		Node node4_2 = new Node(25, 25);
		Node node4_3 = new Node(75, 75);
		Node node4_4 = new Node(10, 10);
		Node node4_5 = new Node(30, 30);
		Node node4_6 = new Node(60, 60);
		Node node4_7 = new Node(80, 80);
		
		node4_1.setLeft(node4_2);
		node4_1.setRight(node4_3);
		node4_2.setLeft(node4_4);
		node4_2.setRight(node4_5);
		node4_3.setLeft(node4_6);
		node4_3.setRight(node4_7);
		
		bst4.setRoot(node4_1);
		
		System.out.println("[Task 1]");
		bst4.print();
		System.out.println();
		System.out.println(bst4.checkBST());
		
		Node node5_1 = new Node(50, 50);
		Node node5_2 = new Node(25, 25);
		Node node5_3 = new Node(75, 75);
		Node node5_4 = new Node(10, 10);
		Node node5_5 = new Node(30, 30);
		Node node5_6 = new Node(80, 80);
		Node node5_7 = new Node(60, 60);
		
		node5_1.setLeft(node5_2);
		node5_1.setRight(node5_3);
		node5_2.setLeft(node5_4);
		node5_2.setRight(node5_5);
		node5_3.setLeft(node5_6);
		node5_3.setRight(node5_7);
		
		bst5.setRoot(node5_1);
		
		System.out.println("[Task 2]");
		bst5.print();
		System.out.println();
		System.out.println(bst5.checkBST());
		
	}
}