
public class Node<Key extends Comparable<Key>, Value> {
	// Key�� Value�� generic Ÿ���̰� Key�� �� ������ ���� �ڹ��� Comparable �������̽��� ��ӹ���
	// Ű�� ���� �� Comparable�� ����Ǿ� �ִ� compareTo �޼ҵ带 ����ؼ� �� ������ ����
	private Key id;
	private Value name;
	private Node left, right;

	public Node(Key newId, Value newName) {
		id = newId;
		name = newName;
		left = right = null; // ��, ������ �ڽ� ���۷����� null�� �ʱ�ȭ
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
