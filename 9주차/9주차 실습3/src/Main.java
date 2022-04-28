import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList<LinkedList> lt = new LinkedList<LinkedList>();
		BinaryTree tA = new BinaryTree();
		BinaryTree tB = new BinaryTree();
		
		
		Node node8A = new Node(800, null, null);
		Node node4A = new Node(400, node8A, null);
		Node node5A = new Node(500, null, null);
		Node node6A = new Node(600, null, null);
		Node node7A = new Node(700, null, null);
		Node node2A = new Node(200, node4A, node5A);
		Node node3A = new Node(300, node6A, node7A);
		Node node1A = new Node(100, node2A, node3A);
		
		tA.setRoot(node1A);
		
		//Node nodeX = new Node(800, null, null);
		Node node9B = new Node(700, null, null);
		Node node8B = new Node(600, null, null);
		Node node4B = new Node(300, node8B, node9B);
		Node node5B = new Node(7, null, null);
		Node node6B = new Node(9, null, null);
		Node node7B = new Node(70, null, null);
		Node node2B = new Node(2, node4B, node5B);
		Node node3B = new Node(3, node6B, node7B);
		Node node1B = new Node(1, node2B, node3B);
	
		tB.setRoot(node1B);
		
		for (int i = 0; i < tA.subTreeCompare(tB).size(); i++) {
			System.out.println("Found a matching subtree " + (i + 1) + ":");
			tA.levelorder((Node) tA.subTreeCompare(tB).get(i));
			System.out.println();
		}
	}
}
