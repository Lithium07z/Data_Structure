import java.util.EmptyStackException;

public class ListStack<E> {
	private Node<E> top;
	private int size;

	public ListStack() {
		top = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getItem();
	}

	public void push(E newItem) {
		Node newNode = new Node(newItem, top);
		top = newNode;
		size++;
	}

	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		E topItem = top.getItem();
		top = top.getNext();
		size--;
		return topItem;
	}
	
	public void print() {
		E[] arr = (E[])new Object[size];
		int cnt = size;
		for (int i = 0; i < cnt; i++) {
			arr[i] = pop();
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = cnt - 1; i >= 0; i--) {
			push(arr[i]);
		}
	}
}
