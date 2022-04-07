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

	public String getPostEq(String s) {
		String value = ""; // ����ǥ����� ���� String ����
		int count = 0; // �Ŀ� �Ұ�ȣ�� ���´ٰ� �������� ��, ���� ��ȣ�� �������� �˻��ϴ� ����
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') { // �����ڸ�
				count++; // ��ȣ�� �߰��Ǹ� +1
				push((E) "("); // ���ÿ� ����
			} else if (s.charAt(i) == '*') {
				push((E) "*");
			} else if (s.charAt(i) == '/') {
				push((E) "/");
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				// ���ϱ�, ����� �ڽ��� �켱�������� ���� �����ڰ� top�� �ö����� pop�ؾ� ��
				for (int j = 0; j < size(); j++) { // �ȿ� �ִ°� �� ��
					if (String.valueOf(peek()).equals("(")) { // ��, ���� ��ȣ�� ������ pop���� ����
						break; // Ż��
					} else {
						value += String.valueOf(pop()); // pop�Ѱ� value�� �߰�
					}
				}
				push((E) String.valueOf(s.charAt(i))); // ���� ��ȣ�� �־ pop�� ���ϸ� ���ÿ� �߰�
			} else if (s.charAt(i) == ')') { // �ݴ� ��ȣ��
				count++; // ��ȣ�� ������ +1
				int fixSize = size(); // ���ݻ����� ����ϰ�
				for (int j = 0; j < fixSize; j++) { // ���� �����ŭ �ݺ��ؼ� pop
					String add = String.valueOf(pop()); // pop�� �� add�� �����س��� �˻�
					if (add.equals("(")) { // pop�ϴٰ� �ݴ� ��ȣ ������
						break; // �ű����
					} else {
						value += add; // �ƴϸ� �����س��� add, value�� �߰�
					}
				}
			} else {
				value += String.valueOf(s.charAt(i)); // �ǿ������� ��� value�� �߰�
			}
		}
		if (count % 2 != 0) { // ��ȣ�� ¦���� �ƴѰ��
			System.out.println("��ȣ�� ¦�� ���� �ʽ��ϴ�. ���� �ٽ� Ȯ�����ּ���");
			System.exit(0);
		}
		for (int i = 0; i < size(); i++) {
			value += String.valueOf(pop());
		} // �������� ���ÿ� �����ִ� ���� ���� value�� �߰�
		return value; // value ����
	}

	public double calc(String[] s) {
		double front; // double Ÿ������ ���� �� �ǿ����� �����ϴ� ���� 
		double back; // double Ÿ������ �ڿ� ���� �ǿ����� �����ϴ� ���� 
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("*") | s[i].equals("/") || s[i].equals("+") || s[i].equals("-")) { // �����ڸ�
				back = (double) pop(); // ���� pop�ؼ� ������ ���� back��
				front = (double) pop(); // ���� pop�ؼ� ������ ���� front�� �ִ´�
				if (s[i].equals("*")) { // ������ �����ڿ� �´� ���� ����
					push((E) Double.valueOf(front * back)); // double��ü�� ���� ���ʸ����� ĳ����
				} else if (s[i].equals("/")) {
					push((E) Double.valueOf(front / back));
				} else if (s[i].equals("+")) {
					push((E) Double.valueOf(front + back));
				} else if (s[i].equals("-")) {
					push((E) Double.valueOf(front - back));
				}
			} else {
				push((E) Double.valueOf(s[i])); // �ǿ����ڴ� double��ü�� ���� ���ʸ����� ĳ������ �� push
			}
		}
		return (double)peek(); // �� ������ �������� ���ÿ� �ִ� ���� ������̴ϱ� peek�� ������ double������ �ݳ�
	}

	public void print() {
		E[] arr = (E[]) new Object[size];
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
