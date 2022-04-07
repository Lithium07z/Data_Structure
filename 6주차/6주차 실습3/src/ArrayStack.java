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
		for (int i = 0; i < size(); i++) {
			t[i] = s[i];
		}
		s = (E[]) t;
	}

	public boolean checkParentheses(String s) {
		Loop: for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') { // ��ȣ��
				push((E) "("); // ���ÿ� ����
			} else if (s.charAt(i) == '{') {
				push((E) "{");
			} else if (s.charAt(i) == '[') {
				push((E) "[");
			} else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') { // �ݴ� ��ȣ��
				String compare = null;
				if (s.charAt(i) == ')') { // �ݴ� ��ȣ��
					compare = "("; // ¦�̵Ǵ� ��ȣ�� compare�� �ְ�
				} else if (s.charAt(i) == '}') {
					compare = "{";
				} else if (s.charAt(i) == ']') {
					compare = "[";
				}
				for (int j = 0; j < size(); j++) {
					if (String.valueOf(pop()).equals(compare)) { // ������
						continue Loop; // ���� �˻��
					}
				}
				return false; // �ٸ��� false ����
			} // �ƽ�Ű �ڵ� �̿��ؼ� �ڵ� �����Ϸ� �ߴµ� �Ұ�ȣ�� �����ؼ� �־ �Ұ�ȣ�� ���� ���������� :(
		}
		if (size() != 0) { // �˻� �����µ� ���ÿ� ���� ������ ����� ��ȣ�� �ִٴ� �Ŵϱ�
			for (int i = 0; i < size(); i++) { // ���þȿ� ���� ���� ������
				pop(); // �� ������
			}
			return false; // �׸��� false ����
		}
		return true; // �ƴϸ� true
	}

	public boolean checkPalindrome(String s) {
		int pass = -1;
		if (s.length() % 2 != 0) { // Ȧ����
			pass = s.length() / 2; // �ǳʶپ�� �� �߰� �ε��� pass�� ����
		}
		for (int i = 0; i < s.length(); i++) { // ��ü ���̸�ŭ �ݺ��ϴµ�
			if (pass > 0 && i == pass) { // pass�� ������
				continue; // �ű⸸ �н� 
			}
			if (i < s.length() / 2 || s.length() == 1) { // �� ���ݿ���(s.length() == 1�� ������ 1�̸� push�� �ȵǼ� ����)
				push((E) String.valueOf(s.charAt(i))); // ���ÿ� �߰��ϰ�
			} else { // ������ ���ݿ���
				if (String.valueOf(pop()).equals(String.valueOf(s.charAt(i)))) { // ���ÿ� �����Ŷ� ������ ���̶� �˻�
					continue; // ������ continue;
				} else {
					return false; // �ٸ��� false ����
				}
			}
		}
		return true; // �� ����ϸ� true;
	}

	public void print() {
		for (E value : s) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
}