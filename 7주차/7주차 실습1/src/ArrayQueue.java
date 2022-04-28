import java.util.NoSuchElementException;

public class ArrayQueue<E> {
	private E[] q; // 큐를 위한 배열
	private int front, rear, size;

	public ArrayQueue() { // 큐 생성자
		q = (E[]) new Object[2]; // 초기에 크기가 2인 배열 공간 하나는 비워야 하니까
		front = rear = size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void add(E newItem) { // 큐 삽입 연산
		if ((rear + 1) % q.length == front) { // 비어있는 원소가 1개 뿐인 경우(큐가 full인 경우 맨처음 비우는 한 칸을 제외한 모든칸이 꽉 찬)
			resize(2 * q.length);
		}
		rear = (rear + 1) % q.length;
		q[rear] = newItem;
		size++;
	}

	public E remove() {
		if (isEmpty()) {
			throw new NoSuchElementException(); // 이미 비어있는 경우는 underflow방지로 프로그램 정지
		}
		front = (front + 1) % q.length;
		E item = q[front];
		q[front] = null;
		size--;
		if (size > 0 && size == q.length / 4) {
			resize(q.length / 2);
		}
		return item;
	}

	private void resize(int newSize) {
		Object[] t = new Object[newSize];
		for (int i = 1, j = front + 1; i < size + 1; i++, j++) {
			t[i] = q[j % q.length];
		}
		front = 0;
		rear = size;
		q = (E[]) t;
	}
	
	public void print() {
		for (int i = 0; i < q.length; i++) {
			System.out.printf("%s\t ",q[i]);
		}
		System.out.println();
	}
}
