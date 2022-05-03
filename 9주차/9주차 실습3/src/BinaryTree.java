import java.util.ArrayList;
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
		while (!q.isEmpty()) {
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

	public int[] btree2intarr() {
		int[] arr = new int[(int) (Math.pow(2, height(this.root)))]; // 0은 안쓸테니 사이즈 + 1의 크기로 초기화
		Queue<Node> q = new LinkedList<Node>(); // 큐 이용
		Node t;
		int i = 1;
		q.add(root); // 루트 노드를 큐에 삽입
		while (!q.isEmpty()) {
			t = q.remove(); // 큐 가장 앞에있는 노드 제거
			arr[i] = (int) t.getKey(); // 제거된 노드 값을 배열에 추가
			if (t.getLeft() != null) { // 제거된 왼쪽 자식이 null이 아니면
				q.add(t.getLeft()); // 큐에 왼쪽 자식 삽입
			}
			if (t.getRight() != null) { // 제거된 오른쪽 자식이 null이 아니면
				q.add(t.getRight()); // 큐에 오른쪽 자식 삽입
			}
			if (t.getLeft() == null && t.getRight() != null) { // 불완전 이진 트리의 경우 
				q.add(new Node(0, null, null));
			}
			i++; // 배열 인덱스번호 증가
		}
		return arr;
	}

	public void intArrPrint(int[] arr) {
		for (int i = 1; i < (int) (Math.pow(2, height(this.root))); i++) {
			System.out.print("Value of arr[" + i + "] : " + arr[i] + "\n");
		}
	}

	public void intarr2btree(int[] arr) {
		this.root = new Node(null, null, null); // 모든 노드 삭제
		Node[] save = new Node[arr.length];
		for (int i = arr.length - 1; i > 0; i--) { // 노드 생성을 위한 반복문
			Node p = new Node(null, null, null); // 빈 노드 생성
			p.setKey(arr[i]); // 노드 값 추가

			if (2 * i < arr.length) { // ArrayIndextOutOfBounds 예방
				p.setLeft(new Node(arr[2 * i], null, null)); // 왼쪽 노드 추가
			}
			if (2 * i + 1 < arr.length) { // ArrayIndextOutOfBounds 예방
				p.setRight(new Node(arr[2 * i + 1], null, null)); // 오른쪽 노드 추가
			}
			save[i] = p; // 완성된 노드를 배열에 넣음
		}

		for (int i = 1; i <= baseLog(arr.length, 2) + 1; i++) { // 노드 연결을 위한 반복문 높이만큼 반복함 단, 1부터 시작하므로 높이 + 1
			save[i].setLeft(save[2 * i]); // 왼쪽노드 연결
			if (2 * i + 1 < arr.length) { // ArrayIndextOutOfBounds 예방
				save[i].setRight(save[2 * i + 1]); // 오른쪽노드 연결
			}
		}
		setRoot(save[1]); // save 배열의 1번이 루드 노드이기 때문에 root노드로 설정
	}

	public double baseLog(double x, double base) { // 높이 log2(N + 1)에서 밑이 2인 로그를 만들기 위한 메소드
		return Math.log10(x) / Math.log10(base);
	}
	
	public LinkedList<Node> subTreeCompare(BinaryTree t) {
		LinkedList<Node> list = new LinkedList<Node>(); // tA 트리의 노드를 저장할 리스트
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		Node tA = this.root;
		Node tB = t.root; // tB트리의 루트노드를 저장

		q1.add(tA); 
		for (int i = 0; i < size(this.root); i++) {
			tA = q1.remove();
			q2.add(t.root); // tA트리의 노드를 기준으로 tB트리의 노드를 모두 검색하며 비교할거니까 매 검색마다 tB트리의 루트노드를 넣어줌
			for (int j = 0; j < size(t.root); j++) {
				tB = q2.remove();
				if (isEqual(tA, tB)) { // 서브트리까지 같은 노드라면 
					list.add(tA); // 리스트에 추가 
				}
				if (tB.getLeft() != null) { 
					q2.add(tB.getLeft()); 
				}
				if (tB.getRight() != null) { 
					q2.add(tB.getRight()); 
				}
			}
			if (tA.getLeft() != null) { 
				q1.add(tA.getLeft()); 
			}
			if (tA.getRight() != null) { 
				q1.add(tA.getRight()); 
			}
		}
		return list;
	}
	
}	
