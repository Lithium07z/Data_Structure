import java.util.NoSuchElementException;

public class ArrList <E>{
	private E a[];
	private int size;
	
	public ArrList() {
		a = (E[]) new Object[1]; // ���ʸ� Ÿ���̱⿡ Object�� ����� ��� �� ���� �����ϰ�
		size = 0;
	}
	
	public E peek(int k) {
		if (size == 0 || k >= size) { // �����Ͱ� ���ų� �ε��� k�� sizeũ�� ���� ũ��
			throw new NoSuchElementException(); // �� ���� ����ó��
		}
		return a[k];
	}
	public boolean isEmpty() { // �迭�� ������ ���� True, False
		if (size == 0) {
			return true;
		}
		return false;
	}
	public void insertLast(E newItem) { // ���Ĺ̿� �� �߰�
		if (size == a.length) { // �迭�� ��á�ٸ�
			resize(a.length * 2); // 2��� Ȯ��
		}
		a[size++] = newItem; // �� �׸� ���� + ������ ���� [size != length ����!!]
	}
	public void insert(E newItem, int k) {
		if (size == a.length) { // �迭�� ��á�ٸ�
			resize(a.length * 2); // 2��� Ȯ��
		}
		for (int i = size - 1; i >= k ; i--) { // ������ ������
			a[i + 1] = a[i]; // �ڷ� �ϳ��� �̵���Ű��
		}
		a[k] = newItem; // �̵��� ������ �� ������ �� �߰�
		size++; // ��ü �迭�� ũ�Ⱑ ���������� size++
	}
	public void insert(E newItem) { // �޼ҵ� �����ε�
		insertLast(newItem); // ���� �߰��ϱ� ���� ���� ������ ���Ĺ� �߰�
	}
	private void resize(int newSize) { // ���ο� �迭ũ�� ����
		Object[] t = new Object[newSize]; // �ֻ��� ��ü�� Objcet�� �� �迭 ����
		for (int i = 0; i < size; i++) {
			t[i] = a[i]; // ���� ������� �迭�� ������ �ֱ�
		}
		a = (E[])t; // ������ ���簡 ���� �迭�� ���ʸ�Ÿ������ ĳ�������� 
	}
	public E delete(int k) { // ������ �ε��� k 
		if (isEmpty()) {
			throw new NoSuchElementException(); // underflow
		}
		E item = a[k]; // �����ϱ����� �ӽ�����
		for (int i = k; i < size - 1; i++ ) {
			a[i] = a[i + 1];
		}
		size--;
		if (size > 0 && size <= a.length/4) { // �迭�� 4���� 1�� ����
			resize(a.length/2); // �迭�� ���� ����
		}
		return item; // ������ item ��ȯ
	}
	public void print() {
		for (int i = 0; i < a.length; i++) {
			if (i < size) {
				System.out.print(a[i] + "\t"); // �� ����� ��
			} else {
				System.out.print("null\t"); // �� ���� null�� ����� ����
			}
		}
		System.out.println();
	}
}