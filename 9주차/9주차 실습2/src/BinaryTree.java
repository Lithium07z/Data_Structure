import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>> {
	private Node root;

	public BinaryTree() {
		this.root = null;
	}

	public Node getRoot() {
		return this.root;
	}

	public void setRoot(Node newRoot) {
		this.root = newRoot;
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	public void preorder(Node n) { // ������ȸ
		if (n != null) {
			System.out.print(n.getKey() + " "); // ��� n �湮
			preorder(n.getLeft()); // n�� ���� ����Ʈ���� ��ȸ�ϱ� ����
			preorder(n.getRight()); // n�� ������ ����Ʈ���� ��ȸ�ϱ� ����
		}
	}

	public void inorder(Node n) { // ������ȸ
		if (n != null) {
			inorder(n.getLeft()); // n�� ���� ����Ʈ���� ��ȸ�ϱ� ����
			System.out.print(n.getKey() + " "); // ��� n �湮
			inorder(n.getRight()); // n�� ������ ����Ʈ���� ��ȸ�ϱ� ����
		}
	}

	public void postorder(Node n) { // ������ȸ
		if (n != null) {
			postorder(n.getLeft()); // n�� ���� ����Ʈ���� ��ȸ�ϱ� ����
			postorder(n.getRight()); // n�� ������ ����Ʈ���� ��ȸ�ϱ� ����
			System.out.print(n.getKey() + " "); // ��� n �湮
		}
	}

	public void levelorder(Node root) { // ������ȸ
		Queue<Node> q = new LinkedList<Node>(); // ť �̿�
		Node t;
		q.add(root); // ��Ʈ ��带 ť�� ����
		while (!q.isEmpty()) {
			t = q.remove(); // ť ���� �տ��ִ� ��� ����
			System.out.print(t.getKey() + " "); // ������ ��� ���(�湮)
			if (t.getLeft() != null) { // ���ŵ� ���� �ڽ��� null�� �ƴϸ�
				q.add(t.getLeft()); // ť�� ���� �ڽ� ����
			}
			if (t.getRight() != null) { // ���ŵ� ������ �ڽ��� null�� �ƴϸ�
				q.add(t.getRight()); // ť�� ������ �ڽ� ����
			}
		}
	}

	public int size(Node n) { // n�� ��Ʈ�� �ϴ� (����)Ʈ���� �ִ� ��� ��
		if (n == null) {
			return 0; // null�̸� 0����
		} else {
			return (1 + size(n.getLeft()) + size(n.getRight()));
		}
	}

	public int height(Node n) { // n�� ��Ʈ�� �ϴ� (����)Ʈ���� ����
		if (n == null) {
			return 0; // null�̸� 0����
		} else {
			return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
		}
	}

	public static boolean isEqual(Node n, Node m) { // �� Ʈ���� ���ϼ� �˻�
		if (n == null || m == null) { // �� �� �ϳ��� null�̸�
			return n == m; // �Ѵ� null���� Ȯ���� null�̸� true �ƴϸ� false
		}
		if (n.getKey().compareTo(m.getKey()) != 0) { // �Ѵ� null�� �ƴϸ� item ��
			return false;
		}
		return (isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight()));
	} // item�� ������ �����ڽ� ���ȣ�� and ������ �ڽ� ���ȣ��

	public int[] btree2intarr() {
		int[] arr = new int[(int) (Math.pow(2, height(this.root)))]; // �ҿ��� ����Ʈ��, ��ȭ ����Ʈ���� ��츦 ������ �ش� ���̿��� ���� �� �ִ� �ִ� ��� ������ ����
		Queue<Node> q = new LinkedList<Node>(); // ť �̿�
		Node t;
		int i = 1;
		q.add(root); // ��Ʈ ��带 ť�� ����
		while (!q.isEmpty()) {
			t = q.remove(); // ť ���� �տ��ִ� ��� ����
			arr[i] = (int) t.getKey(); // ���ŵ� ��� ���� �迭�� �߰�
			if (t.getLeft() != null) { // ���ŵ� ���� �ڽ��� null�� �ƴϸ�
				q.add(t.getLeft()); // ť�� ���� �ڽ� ����
			}
			if (t.getRight() != null) { // ���ŵ� ������ �ڽ��� null�� �ƴϸ�
				q.add(t.getRight()); // ť�� ������ �ڽ� ����
			}
			if (t.getLeft() == null && t.getRight() != null) { // �ҿ��� ���� Ʈ���� ��� 
				q.add(new Node(0, null, null));
			}
			i++; // �迭 �ε�����ȣ ����
		}
		return arr;
	}

	public void intArrPrint(int[] arr) {
		for (int i = 1; i < (int) (Math.pow(2, height(this.root))); i++) {
			System.out.print("Value of arr[" + i + "] : " + arr[i] + "\n");
		}
	}

	public void intarr2btree(int[] arr) {
		this.root = new Node(null, null, null); // ��� ��� ���� 
		Node[] save = new Node[arr.length];
		for (int i = arr.length - 1; i > 0; i--) { // ��� ������ ���� �ݺ���
			Node p = new Node(null, null, null); // �� ��� ����
			p.setKey(arr[i]); // ��� �� �߰� 
			
			if (2 * i < arr.length) { // ArrayIndextOutOfBounds ����
				p.setLeft(new Node(arr[2 * i], null, null)); // ���� ��� �߰�
			}
			if (2 * i + 1 < arr.length) { // ArrayIndextOutOfBounds ����
				p.setRight(new Node(arr[2 * i + 1], null, null)); // ������ ��� �߰� 
			}
			save[i] = p; // �ϼ��� ��带 �迭�� ���� 
		}
		
		for (int i = 1; i <= baseLog(arr.length, 2) + 1; i++) { // ��� ������ ���� �ݺ��� ���̸�ŭ �ݺ��� ��, 1���� �����ϹǷ� ���� + 1
			save[i].setLeft(save[2 * i]); // ���ʳ�� ����
			if (2 * i + 1 < arr.length) { // ArrayIndextOutOfBounds ����
				save[i].setRight(save[2 * i + 1]); // �����ʳ�� ����
			}
		}
		setRoot(save[1]); // save �迭�� 1���� ��� ����̱� ������ root���� ����
	}

	public double baseLog(double x, double base) { // ���� log2(N + 1)���� ���� 2�� �α׸� ����� ���� �޼ҵ�
		return Math.log10(x) / Math.log10(base);
	}

}