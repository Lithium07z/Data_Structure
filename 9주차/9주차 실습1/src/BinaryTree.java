import java.util.*;

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

	public void preorder(Node n) { // 전위순회
		if (n != null) {
			System.out.print(n.getKey() + " "); // 노드 n 방문
			preorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
			preorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
		}
	}
	
	public void inorder(Node n) { // 중위순회
		if (n != null) {
			inorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
			System.out.print(n.getKey() + " "); // 노드 n 방문
			inorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
		}
	}
	
	public void postorder(Node n) { // 후위순회
		if (n != null) {
			postorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
			postorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
			System.out.print(n.getKey() + " "); // 노드 n 방문
		}
	}
	
	public void levelorder(Node root) { // 레벨순회
		Queue<Node> q = new LinkedList<Node>(); // 큐 이용
		Node t;
		q.add(root); // 루트 노드를 큐에 삽입
		while(!q.isEmpty()) {
			t = q.remove(); // 큐 가장 앞에있는 노드 제거
			System.out.print(t.getKey() + " "); // 제거한 노드 출력(방문)
			if (t.getLeft() != null) { // 제거된 왼쪽 자식이 null이 아니면
 				q.add(t.getLeft()); // 큐에 왼쪽 자식 삽입
			}
			if (t.getRight() != null) { // 제거된 오른쪽 자식이 null이 아니면
				q.add(t.getRight()); // 큐에 오른쪽 자식 삽입
			}
		}
	}
	
	public int size(Node n) { // n을 루트로 하는 (서브)트리에 있는 노드 수
		if (n == null) {
			return 0; // null이면 0리턴
		} else {
			return (1 + size(n.getLeft()) + size(n.getRight()));
		}
	}
	
	public int height(Node n) { // n을 루트로 하는 (서브)트리의 높이
		if (n == null) {
			return 0; // null이면 0리턴
		} else {
			return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
		}
	}
	
	public static boolean isEqual(Node n, Node m) { // 두 트리의 동일성 검사
		if (n == null || m == null) { // 둘 중 하나라도 null이면
			return n == m; // 둘다 null인지 확인후 null이면 true 아니면 false
		}
		if (n.getKey().compareTo(m.getKey()) != 0) { // 둘다 null이 아니면 item 비교
			return false;
		}
		return (isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight()));
	} // item이 같으면 왼쪽자식 재귀호출 and 오른쪽 자식 재귀호출
}
