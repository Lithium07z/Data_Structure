import java.util.NoSuchElementException;

public class CList <E> {
	private Node last; // ����Ʈ�� ������ ���(�׸�)�� ����Ų��.
	private int size; // ����Ʈ�� �׸�(���) ��
	
	public CList() { // ����Ʈ ������
		this.last = null;
		this.size = 0;
	}
	
	public void insert(int newItem) { // last�� ����Ű�� ����� ������ �� ��� ����
		Node newNode = new Node(newItem, null); // �� ��� ����
		if (last == null) { // last�� ����� �� 
			newNode.setNext(newNode); 
			last = newNode;
		} else {
			newNode.setNext(last.getNext());
			last.setNext(newNode);
		}
		size++;
	}
	
	public Node delete() { // last�� ����Ű�� ����� ���� ��带 ����
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Node x = last.getNext(); // x�� ����Ʈ�� ù ��带 ����Ŵ
		if (x == last) { // ����Ʈ�� 1���� ��常 �ִ� ��� 
			last = null;
		} else {
			last.setNext(x.getNext()); // last�� ����Ű�� ����� ���� ��尡 x�� ���� ��尡 �ǵ��� 
			x.setNext(null); // x�� next�� null�� �����.
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
	
	public void rotateLeft(int n) {
		for (int i = 0; i < n; i++) {
			last = last.getNext(); // ��� ���������� �о������ 
		}
	}
	
	public void rotateRight(int n) {
		for (int i = 0; i < size - n; i++) {
			last = last.getNext(); // �������δ� �����ϱ� ȯ���̶�°� �̿��ؼ� ������� �̵��Ϸ��� �� ��ŭ ���� ��
		}
	}
	
	public void print() {
		Node out = this.last.getNext();
		for (int i = 0; i < this.size; i++) {
			System.out.print(out.getItem() + " ");
			out = out.getNext();
		}
	}
}