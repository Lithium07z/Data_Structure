import java.util.EmptyStackException;

public class ArrayStack<E> {
	private E s[]; // ������ ���� �迭
	private int top; // ������ top �׸��� �迭 ���� �ε���

	public ArrayStack() { // ���� ������
		s = (E[]) new Object[1]; // ó���� ũ�Ⱑ 1�� �迭 ����
		top = -1;
	}

	public int size() {
		return top + 1; // ���ÿ� �ִ� �׸��� ���� ����
	}

	public boolean isEmpty() { // ������ empty�� true ����
		return top == -1;
	}

	public E peek() { // ���� top �׸��� ���븸�� ����
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return s[top];
	}

	public void push(E newItem) { // push ����
		if (size() == s.length) {
			resize(2 * s.length); // ������ 2���� ũ��� Ȯ��
		}
		s[++top] = newItem; // �� �׸� push
	}

	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		E item = s[top];
		s[top--] = null; // null�� �ʱ�ȭ
		if (size() > 0 && size() == s.length / 4) { // ����� ���� �迭�� 1/4 ũ���
			resize(s.length / 2); // ������ ������ ���
		}
		return item;
	}

	public void resize(int newSize) {
		Object[] t = new Object[newSize];
		for (int i = 0; i < top + 1; i++) {
			t[i] = s[i];
		}
		s = (E[]) t;
	}
	
	public void print() {
		for (E value : s) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
}
