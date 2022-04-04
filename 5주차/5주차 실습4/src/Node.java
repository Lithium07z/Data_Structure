
public class Node <E>{
	private int item;
	private Node<E> next;
	
	public Node(int newItem, Node<E> node) { // ������
		item = newItem;
		next = node;
	}
	//getter, setter �޼ҵ�
	public int getItem() {
		return this.item;
	}
	public Node<E> getNext() {
		return this.next;
	}
	public void setItem(int newItem) {
		item = newItem;
	}
	public void setNext(Node<E> newNext) {
		next = newNext;
	}
}
