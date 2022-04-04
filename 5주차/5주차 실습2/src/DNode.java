
public class DNode <E> {
	private E item;
	private DNode previous;
	private DNode<E> next;
	
	public DNode(E newItem, DNode p, DNode q) { // ������
		item = newItem;
		previous = p;
		next = q;
	}
	//getter, setter �޼ҵ�
	public E getItem() {
		return this.item;
	}
	public DNode<E> getPrevious() {
		return previous;
	}
	public DNode<E> getNext() {
		return this.next;
	}
	public void setItem(E newItem) {
		item = newItem;
	}
	public void setPrevious(DNode p) {
		previous = p;
	}
	public void setNext(DNode q) {
		next = q;
	}
}
