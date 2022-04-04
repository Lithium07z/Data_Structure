import java.util.NoSuchElementException;

public class CList <E> {
	private Node last; // 리스트의 마지막 노드(항목)을 가리킨다.
	private int size; // 리스트의 항목(노드) 수
	
	public CList() { // 리스트 생성자
		this.last = null;
		this.size = 0;
	}
	
	public void insert(E newItem) { // last가 가리키는 노드의 다음에 새 노드 삽입
		Node newNode = new Node(newItem, null); // 새 노드 생성
		if (last == null) { // last가 비었을 때 
			newNode.setNext(newNode); 
			last = newNode;
		} else {
			newNode.setNext(last.getNext());
			last.setNext(newNode);
		}
		size++;
	}
	
	public Node delete() { // last가 가리키는 노드의 다음 노드를 제거
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Node x = last.getNext(); // x가 리스트의 첫 노드를 가리킴
		if (x == last) { // 리스트에 1개의 노드만 있는 경우 
			last = null;
		} else {
			last.setNext(x.getNext()); // last가 가리키는 노드의 다음 노드가 x의 다음 노드가 되도록 
			x.setNext(null); // x의 next를 null로 만든다.
		}
		size--;
		return x;
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public void print() {
		Node out = this.last.getNext();
		for (int i = 0; i < this.size; i++) {
			System.out.print(out.getItem() + " ");
			out = out.getNext();
		}
	}
}
