import java.util.NoSuchElementException;

public class SList<E> {
	protected Node head; // ���Ḯ��Ʈ�� ù ��带 ����Ŵ
	private int size;

	public SList() { // ���Ḯ��Ʈ ������
		head = null;
		size = 0;
	}

	public int search(int target) { // target���� Ž��
		Node p = head;
		for (int k = 0; k < size; k++) {
			if (target == p.getItem()) { // p ����� item�� target�� ��ġ�ϸ�
				return k; // �ش���ġ ��ȯ
			}
			p = p.getNext();
		}
		return -1; // Ž�� ���н� -1 ��ȯ
	}

	public void insertFront(int newItem) { // ���Ḯ��Ʈ �� �տ� �� ��� ����
		head = new Node(newItem, head); // �߰��Ϸ��� �� item���� head�� ����Ű�� �ּҸ� ������ ���ο� ��� ����
		size++; // �� �߰��Ǿ����� ������ ����
	}

	public void insertAfter(int newItem, Node p) { // ��� p �ٷ� ������ �� ��� ����
		p.setNext(new Node(newItem, p.getNext()));
		// �߰��Ϸ��� �� ���� ������ p�� ����Ű�� �ּҸ� ������ �� ��带 ���� �� p.�� ���� ������� ���� ����ǰ� ��
		size++;
	}

	public void deleteFront() {
		if (size == 0) {
			throw new NoSuchElementException(); // ����� 0�̶� ����� ������ Exception ������
		}
		head = head.getNext();
		size--;
	}

	public void deleteAfter(Node p) { // p�� ����Ű�� ����� ���� ��带 ����
		if (p == null) {
			throw new NoSuchElementException(); // p�� ������ ���� ���� ��尡 ���� ��
		}
		Node t = p.getNext(); // ��� t�� p�� ���� ��带 ����
		if (t != null) { // p ������ ��ȿ�� ��尡 �ִ� ���
			p.setNext(t.getNext());
			// ���t�� ���� ��带 p�� ���� ���� ������ �ᱹ p�� �ٴ��� ��尡 p���� ��带 ������ �� ��ũ�� ����̹Ƿ� �̷��� ��
			t.setNext(null); // ���t�� �����ϴ� ��ũ�� ������ ���t�� p�� ������ ���� ������ null���� �������μ� ����
			size--; // ���������� ������ ����
		} else {
		} // p.next�� t�� null�̸�, �ƹ��͵� �Ұ� ����
	}

	public int size() {
		return this.size;
	}

	public void setAndOrderNodes(int[] arr) {
		int value = this.size;
		if (arr != null) {
			for (int i = 0; i < value; i++) {
				deleteFront();
			}
		} else {
			return;
		}

		Loop: for (int i = 0; i < arr.length; i++) {
			Node next = head; // �� ó���� ��尪 �ִ� ���
			Node before = null; // next��� �� ���� ��� ����Ϸ��� ���
			if (size == 0) { // �ƹ��͵� ������
				insertFront(arr[0]); // �迭 ù ��°�� �ϴ� �ֱ�
			} else { // ����Ʈ�� ���� ��������� ����
				if (head.getItem() >= arr[i]) { // ��� ���� arr[i]���� ũ�ų� ������
					insertFront(arr[i]); // arr[i]�� �� �տ� �־ ���� ����
					continue; // �������� �Ʒ� �ڵ� �����ϰ� ����
				}
				for (int k = 0; k < size; k++) { // ������ ��ŭ �ݺ� 
					if (next.getItem() > arr[i]) { // next���� arr[i]���� ũ��
						insertAfter(arr[i], before); // next���� arr[i]�߰�
						continue Loop; // Loop�� Ż��
					}
					if (next.getNext() != null) { // next������ null�� �ƴҶ���
						before = next; // before�� ���� �� �ְ�
						next = next.getNext(); // next�� ������ ���� �̷��� before�� �׻� next���̰� �� ĭ�� �̵��ϸ鼭 �˻�
					}
				}
				insertAfter(arr[i], next); // ����Ʈ �������� ���� ũ�� �߰�
			} // ������ �޼ҵ� �� �̰� ����ٰ� ��ȣ�� 5�ð����� �Ӹ� ����
		}
	}

	public void reverse() {
		int arr[] = new int[this.size]; // ���� �� ���� �� �迭
		int value = this.size; // ���� ũ�� ����ϴ� ����
		Node loop = head; // ������ ��� 
		for (int i = 0; i < this.size; i++) {
			arr[i] = loop.getItem(); // ��� �� �迭�� �ְ�
			loop = loop.getNext(); // ���� ���� ����
		}
		for (int i = 0; i < value; i++) { // ���� ����ִ� �� �� �о������
			deleteFront();
		}
		for (int i = 0; i < value; i++) { // ��¥�� �պ��� �߰��ϸ� �ڷ� �и��鼭 ������ 
			insertFront(arr[i]);
		}
 	}

	public void join(SList slist2) {
		int arr[] = new int[size + slist2.size]; // �� ����Ʈ ������ ��ŭ�� ���̸�ŭ�� �迭 ���� 
		Node value1 = this.head; // �⺻�� �Ǵ� ����Ʈ�� head ��带 value1�� �ֱ�
		Node value2 = slist2.head; // ��ġ���� ���� ����Ʈ�� head ��带 value2�� �ֱ�
		for (int m = 0; m < this.size + slist2.size; m++) { // �� ����Ʈ ������ ��ŭ�� �迭 ���̸�ŭ �ݺ� 
			if (m < this.size) { // ������ �Ǵ� ����Ʈ �����ŭ�� ������ �Ǵ� ����Ʈ�� ��� ���� �ְ�
				arr[m] = value1.getItem(); 
				value1 = value1.getNext(); // ��� �������� ��� �ѱ�� 
			} else { // �� �������� ��ġ���� ���� ����Ʈ ��� �� �ֱ� 
				arr[m] = value2.getItem();
				value2 = value2.getNext(); // ��� �������� ��� �ѱ��
			}
		}
		setAndOrderNodes(arr); // �ϼ��� �迭�� setAndOrderNodes�� ��������
	}

	public void print() {
		Node out = this.head;
		for (int i = 0; i < this.size; i++) {
			System.out.print(out.getItem() + " ");
			out = out.getNext();
		}
		System.out.println();
	}
}