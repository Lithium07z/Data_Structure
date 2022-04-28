import java.util.NoSuchElementException;

public class ListQueue <E>{
	private Node<E> front, rear;
	private int size;
	public ListQueue() {
		front = rear = null;
		size = 0;
	}
	public int size() { // ť�� �׸� ���� ����
		return size;
	}
	public boolean isEmpty() { // ������� true����
		return size() == 0;
	}
	public void add(E newItem) {
		Node newNode = new Node(newItem, null); // �� ��� ����
		if (isEmpty()) { // ť�� ������� fornt�� newNode�� ����Ű����
			front = newNode; 
		} else { 
			rear.setNext(newNode);; // �ƴϸ� rear�� next�� newNode�� ����Ű�� ��
		}
		rear = newNode;  // ���������� rear�� newNode�� ����Ű�� ��
		size++; // ť �׸� �� 1 ����
	}
	public E remove() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		E frontItem = front.getItem();
		front = front.getNext();
		size--;
		if (isEmpty()) {
			rear = null;
		}
		return frontItem;
	}
	
	public void print() {
		Node p = front;
		for (int i = 0; i < size; i++) {
			System.out.printf("%s\t ",p.getItem());
			p = p.getNext();
		}
		System.out.println();
	}
}
