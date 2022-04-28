
public class Main {
	public static void main(String[] args) {
		BinaryTree t1 = new BinaryTree();
		BinaryTree t2 = new BinaryTree();
		
		Node node8 = new Node(800, null, null);
		Node node4 = new Node(400, node8, null);
		Node node5 = new Node(500, null, null);
		Node node2 = new Node(200, node4, node5);
		Node node6 = new Node(600, null, null);
		Node node7 = new Node(700, null, null);
		Node node3 = new Node(300, node6, node7);
		Node node1 = new Node(100, node2, node3);
		
		t1.setRoot(node1);
		t2.setRoot(node1);
		System.out.println("Ʈ�� ��� �� = " + t1.size(node1));
		System.out.println("Ʈ�� ���� = " + t1.height(node1));
		System.out.print("������ȸ : ");
		t1.preorder(node1);
		System.out.print("\n������ȸ : ");
		t1.inorder(node1);
		System.out.print("\n������ȸ : ");
		t1.postorder(node1);
		System.out.print("\n������ȸ : ");
		t1.levelorder(node1);
		System.out.println("\n���ϼ� �˻� : " + t1.isEqual(t1.getRoot(), t2.getRoot()));
	}
}
