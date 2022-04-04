import java.util.NoSuchElementException;

public class SList<E> {
	protected Node head; // ���Ḯ��Ʈ�� ù ��带 ����Ŵ
	private int size;

	public SList() { // ���Ḯ��Ʈ ������
		head = null;
		size = 0;
	}

	public int search(E target) { // target���� Ž��
		Node p = head;
		for (int k = 0; k < size; k++) {
			if (target == p.getItem()) { // p ����� item�� target�� ��ġ�ϸ�
				return k; // �ش���ġ ��ȯ
			}
			p = p.getNext();
		}
		return -1; // Ž�� ���н� -1 ��ȯ
	}

	public void insertFront(E newItem) { // ���Ḯ��Ʈ �� �տ� �� ��� ����
		head = new Node(newItem, head); // �߰��Ϸ��� �� item���� head�� ����Ű�� �ּҸ� ������ ���ο� ��� ����
		size++; // �� �߰��Ǿ����� ������ ����
	}

	public void insertAfter(E newItem, Node p) { // ��� p �ٷ� ������ �� ��� ����
		p.setNext(new Node(newItem, p.getNext()));
		// �߰��Ϸ��� �� ���� ������ p�� ����Ű�� �ּҸ� ������ �� ��带 ���� �� p.�� ���� ������� ���� ����ǰ� ��
		size++;
	}

	public void deleteFront() {
		if (size == 0) {
			throw new NoSuchElementException(); // ����� 0�̶� ����� ������ Exception ������
		}
		head = head.getNext();
		size--;
	}

	public void deleteAfter(Node p) { // p�� ����Ű�� ����� ���� ��带 ����
		if (p == null) {
			throw new NoSuchElementException(); // p�� ������ ���� ���� ��尡 ���� ��
		}
		Node t = p.getNext(); // ��� t�� p�� ���� ��带 ���� 
		if (t != null) { // p ������ ��ȿ�� ��尡 �ִ� ���
			p.setNext(t.getNext()); 
			// ���t�� ���� ��带 p�� ���� ���� ������ �ᱹ p�� �ٴ��� ��尡 p���� ��带 ������ �� ��ũ�� ����̹Ƿ� �̷��� �� 
			t.setNext(null); // ���t�� �����ϴ� ��ũ�� ������ ���t�� p�� ������ ���� ������ null���� �������μ� ���� 
			size--; // ���������� ������ ���� 
		} else {} // p.next�� t�� null�̸�, �ƹ��͵� �Ұ� ���� 
	}
	
	public int size() {
		return this.size;
	}
	
	public void print() {
		Node out = this.head;
		for (int i = 0; i < this.size; i++) {
			System.out.print(out.getItem() + " ");
			out = out.getNext();
		}
	}
}
