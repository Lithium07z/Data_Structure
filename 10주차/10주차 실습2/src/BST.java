
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
		if (n == null) {  // k를 발견 못하는 경우
			return null;
		}
		int t = n.getKey().compareTo(k);
		if (t > 0) { // if (k < 노드n의 id) 왼쪽 서브트리 탐색
			return get(n.getLeft(), k);
		} 
		else if (t < 0) { // if (k > 노드n의 id) 오른쪽 서브트리 탐색
			return get(n.getRight(), k);
		} 
		else { // k를 가진 노드 발견
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
		if (t > 0) { // if (k < 노드n의 id) 왼쪽 서브트리에 삽입
			n.setLeft(put(n.getLeft(), k, v));
		} 
		else if (t < 0) { // if (k > 노드n의 id) 오른쪽 서브트리에 삽입
			n.setRight(put(n.getRight(), k, v));
		} 
		else { // 노드 n의 name을 v로 갱신
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
			System.out.println("Empty 트리");
		} else {
			root = deleteMin(root);
		}
	}

	private Node deleteMin(Node n) {
		if (n.getLeft() == null) { // if (n의 왼쪽자식 == null) n의 오른쪽자식 리턴
			return n.getRight();
		} 
		n.setLeft(deleteMin(n.getLeft())); // if (n의 오른쪽자식 != null) n의 왼쪽자식으로 재귀호출
		return n;
	}

	public void deleteMax() {
		if (root == null) {
			System.out.println("Empty 트리");
		} else {
			root = deleteMax(root);
		}
	}
	
	private Node deleteMax(Node n) {
		if (n.getRight() == null) { // if (n의 오른쪽자식 == null) n의 왼쪽자식 리턴
			return n.getLeft();
		} 
		n.setRight(deleteMax(n.getRight())); // if (n의 오른쪽자식 != null) n의 왼쪽자식으로 재귀호출
		return n;
	}
	
	public void delete(Key k) {
		root = delete(root, k);
	}

	public Node delete(Node n, Key k) {
		if (n == null)
			return null;
		int t = n.getKey().compareTo(k);
		if (t > 0) { // if (k < 노드n의 id) 왼쪽 자식으로 이동
			n.setLeft(delete(n.getLeft(), k));
		} 
		else if (t < 0) { // if (k > 노드n의 id) 오른쪽 자식으로 이동
			n.setRight(delete(n.getRight(), k));
		} 
		else { // 삭제할 노드 발견
			if (n.getRight() == null) { // case 0 or case 1
				return n.getLeft();
			} 
			if (n.getLeft() == null) { // case 1
				return n.getRight();
			} 
			Node target = n; // case 2 Line 10 ~ 13
			n = min(target.getRight()); // 삭제할 노드 자리로 옮겨올 노드를 찾아서 n이 가리키게 함(중위 후속자)
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