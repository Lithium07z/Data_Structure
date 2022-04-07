import java.util.EmptyStackException;

public class ArrayStack<E> {
	private E s[]; // 스택을 위한 배열
	private int top; // 스택의 top 항목의 배열 원소 인덱스

	public ArrayStack() { // 스택 생성자
		s = (E[]) new Object[1]; // 처음엔 크기가 1인 배열 생성
		top = -1;
	}

	public int size() {
		return top + 1; // 스택에 있는 항목의 수를 리턴
	}

	public boolean isEmpty() { // 스택이 empty면 true 리턴
		return top == -1;
	}

	public E peek() { // 스택 top 항목의 내용만을 리턴
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return s[top];
	}

	public void push(E newItem) { // push 연산
		if (size() == s.length) {
			resize(2 * s.length); // 스택을 2배의 크기로 확장
		}
		s[++top] = newItem; // 새 항목 push
	}

	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		E item = s[top];
		s[top--] = null; // null로 초기화
		if (size() > 0 && size() == s.length / 4) { // 저장된 값이 배열의 1/4 크기면
			resize(s.length / 2); // 스택을 반으로 축소
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
