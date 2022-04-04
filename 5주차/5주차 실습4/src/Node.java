
public class Node <E>{
	private int item;
	private Node<E> next;
	
	public Node(int newItem, Node<E> node) { // 持失切
		item = newItem;
		next = node;
	}
	//getter, setter 五社球
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
