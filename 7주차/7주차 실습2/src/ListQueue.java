import java.util.NoSuchElementException;

public class ListQueue <E>{
	private Node<E> front, rear;
	private int size;
	public ListQueue() {
		front = rear = null;
		size = 0;
	}
	public int size() { // 큐의 항목 수를 리턴
		return size;
	}
	public boolean isEmpty() { // 비었으면 true리턴
		return size() == 0;
	}
	public void add(E newItem) {
		Node newNode = new Node(newItem, null); // 새 노드 생성
		if (isEmpty()) { // 큐가 비었으면 fornt도 newNode를 가리키게함
			front = newNode; 
		} else { 
			rear.setNext(newNode);; // 아니면 rear의 next를 newNode를 가리키게 함
		}
		rear = newNode;  // 마지막으로 rear가 newNode를 가리키게 함
		size++; // 큐 항목 수 1 증가
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
