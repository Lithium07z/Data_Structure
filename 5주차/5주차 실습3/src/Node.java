
public class Node <E> {
	private E item;
	private Node<E> next;
	
	public Node(E newItem, Node<E> node) { // ������
		item = newItem;
		next = node;
	}
	//getter, setter �޼ҵ�
	public E getItem() {
		return this.item;
	}
	public Node<E> getNext() {
		return this.next;
	}
	public void setItem(E newItem) {
		item = newItem;
	}
	public void setNext(Node<E> newNext) {
		next = newNext;
	}
}
