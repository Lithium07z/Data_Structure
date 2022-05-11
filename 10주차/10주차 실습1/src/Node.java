
public class Node<Key extends Comparable<Key>, Value> {
	// Key와 Value는 generic 타입이고 Key는 비교 연산을 위해 자바의 Comparable 인터페이스를 상속받음
	// 키를 비교할 때 Comparable에 선언되어 있는 compareTo 메소드를 사용해서 비교 연산을 수행
	private Key id;
	private Value name;
	private Node left, right;

	public Node(Key newId, Value newName) {
		id = newId;
		name = newName;
		left = right = null; // 왼, 오른쪽 자식 레퍼런스는 null로 초기화
	}

	public Key getKey() {
		return id;
	}

	public Value getValue() {
		return name;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setKey(Key newId) {
		id = newId;
	}

	public void setValue(Value newName) {
		name = newName;
	}

	public void setLeft(Node newLeft) {
		left = newLeft;
	}

	public void setRight(Node newRight) {
		right = newRight;
	}
}
