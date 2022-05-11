
public class BST<Key extends Comparable<Key>, Value> {
	public Node root;

	public Node getRoot() {
		return root;
	}

	public BST(Key newId, Value newName) {
		root = new Node(newId, newName);
	}

	public Value get(Key k) {
		return get(root, k);
	}

	public Value get(Node n, Key k) {
		if (n == null) {  // k�� �߰� ���ϴ� ���
			return null;
		}
		int t = n.getKey().compareTo(k);
		if (t > 0) { // if (k < ���n�� id) ���� ����Ʈ�� Ž��
			return get(n.getLeft(), k);
		} 
		else if (t < 0) { // if (k > ���n�� id) ������ ����Ʈ�� Ž��
			return get(n.getRight(), k);
		} 
		else { // k�� ���� ��� �߰�
			return (Value) n.getValue();
		} 
	}

	public void put(Key k, Value v) {
		root = put(root, k, v);
	}

	public Node put(Node n, Key k, Value v) {
		if (n == null) {
			return new Node(k, v);
		}
		int t = n.getKey().compareTo(k);
		if (t > 0) { // if (k < ���n�� id) ���� ����Ʈ���� ����
			n.setLeft(put(n.getLeft(), k, v));
		} 
		else if (t < 0) { // if (k > ���n�� id) ������ ����Ʈ���� ����
			n.setRight(put(n.getRight(), k, v));
		} 
		else { // ��� n�� name�� v�� ����
			n.setValue(v);
		} 
		return n;
	}

	public Key min() {
		if (root == null) {
			return null;
		}
		return (Key) min(root).getKey();
	}

	private Node min(Node n) {
		if (n.getLeft() == null) {
			return n;
		}
		return min(n.getLeft());
	}
	
	public Key max() {
		if (root == null) {
			return null;
		}
		return (Key) max(root).getKey();
	}

	private Node max(Node n) {
		if (n.getRight() == null) {
			return n;
		}
		return max(n.getRight());
	}

	public void deleteMin() {
		if (root == null) {
			System.out.println("Empty Ʈ��");
		} else {
			root = deleteMin(root);
		}
	}

	private Node deleteMin(Node n) {
		if (n.getLeft() == null) { // if (n�� �����ڽ� == null) n�� �������ڽ� ����
			return n.getRight();
		} 
		n.setLeft(deleteMin(n.getLeft())); // if (n�� �������ڽ� != null) n�� �����ڽ����� ���ȣ��
		return n;
	}

	public void deleteMax() {
		if (root == null) {
			System.out.println("Empty Ʈ��");
		} else {
			root = deleteMax(root);
		}
	}
	
	private Node deleteMax(Node n) {
		if (n.getRight() == null) { // if (n�� �������ڽ� == null) n�� �����ڽ� ����
			return n.getLeft();
		} 
		n.setRight(deleteMax(n.getRight())); // if (n�� �������ڽ� != null) n�� �����ڽ����� ���ȣ��
		return n;
	}
	
	public void delete(Key k) {
		root = delete(root, k);
	}

	public Node delete(Node n, Key k) {
		if (n == null)
			return null;
		int t = n.getKey().compareTo(k);
		if (t > 0) { // if (k < ���n�� id) ���� �ڽ����� �̵�
			n.setLeft(delete(n.getLeft(), k));
		} 
		else if (t < 0) { // if (k > ���n�� id) ������ �ڽ����� �̵�
			n.setRight(delete(n.getRight(), k));
		} 
		else { // ������ ��� �߰�
			if (n.getRight() == null) { // case 0 or case 1
				return n.getLeft();
			} 
			if (n.getLeft() == null) { // case 1
				return n.getRight();
			} 
			Node target = n; // case 2 Line 10 ~ 13
			n = min(target.getRight()); // ������ ��� �ڸ��� �Űܿ� ��带 ã�Ƽ� n�� ����Ű�� ��(���� �ļ���)
			n.setRight(deleteMin(target.getRight()));
			n.setLeft(target.getLeft());
		}
		return n;
	}
	
	public void print() {
		print(root);
	}

	public void print(Node n) {
		if (n != null) {
			print(n.getLeft());
			System.out.print(n.getKey() + " ");
			print(n.getRight());
		}
	}
}