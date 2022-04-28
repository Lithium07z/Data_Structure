
public class Node<Key extends Comparable<Key>> { // 키 비교를 위해 사용
	private Key item;
	private Node<Key> left;
	private Node<Key> right;
	
	public Node(Key newItem, Node lt, Node rt) { // 노드 생성자
		this.item = newItem; this.left = lt; this.right = rt;
	}
	
	public Key getKey() {
		return this.item;
	}
	public Node<Key> getLeft() {
		return this.left;
	}
	public Node<Key> getRight() {
		return this.right;
	}
	public void setKey(Key newItem) {
		this.item = newItem;
	}
	public void setLeft(Node<Key> lt) {
		this.left = lt;
	}
	public void setRight(Node<Key> rt) {
		this.right = rt;
	}
}
