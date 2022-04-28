import java.util.NoSuchElementException;
import java.util.Stack;

public class Type<E> {
	Stack<Object> stk = new Stack<Object>();
	private E[] q; // ť�� ���� �迭
	private int front, rear, size;
	private int time = 0;

	public Type() { // ť ������
		q = (E[]) new Object[2]; // �ʱ⿡ ũ�Ⱑ 2�� �迭 ���� �ϳ��� ����� �ϴϱ�
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

	public void add(E newItem) { // ť ���� ����
		if ((rear + 1) % q.length == front) { // ����ִ� ���Ұ� 1�� ���� ���(ť�� full�� ��� ��ó�� ���� �� ĭ�� ������ ���ĭ�� �� ��)
			resize(2 * q.length);
		}
		rear = (rear + 1) % q.length;
		q[rear] = newItem;
		size++;
	}

	public E remove() {
		if (isEmpty()) {
			throw new NoSuchElementException(); // �̹� ����ִ� ���� underflow������ ���α׷� ����
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

	public int search(String type) {
		for (int i = front + 1; i < q.length; i++) {
			if (q[i] == null) { // null�̸� �� equals �������ϱ�
				continue; // ��Ƽ��
			}
			if (q[i].equals(type)) { // �������� �������̸� Cat���� ��
				return i - front; // ��ġ�ϸ� ��ġ ��ȯ, front �������� ��ġ�� ��ȯ�ؾ� ��
			}
		}
		/*
		 * i���� - front�� ���� front���� i������ �Ÿ��� �� �� �ְ� �̴� front���� ��� �����ؾ� �ش� ��ġ���� �� �� �ְ� ��
		 * search���� �ް� �� adoptAnimal�޼ҵ忡���� i�� 0�� ������ ������ �����ϴ� ���� ������ -1�� �� ���� Ex)
		 * search���� i - front�� 2�� ��ȯ�ϸ� adoptAnimal������ 2��° ������ �ش� ���� ������ �� �̶�,
		 * adoptAnimal�� �ݺ����� 0�������� �����ϱ� ������ 2��°�� �ε����� 1�� ���� i == search() - 1�� ������
		 */
		return -1;
	}
	
	public void print() {
		for (int i = front + 1; i < q.length; i++) { // ù ��°ĭ������ �������� �ʴ� ĭ�̴ϱ� 1���� ������
			if (q[i] == null) { // null�̸� �������
				break;
			}
			System.out.printf("%s\t ", q[i]);
		}
		System.out.println();
	}

}