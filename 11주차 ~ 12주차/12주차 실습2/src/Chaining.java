
public class Chaining<K, V> {
	private int M = 5; // ���̺� ũ��
	private Node[] a = new Node[M]; // �ؽ� ���̺�

	public static class Node { // ��� Ŭ������ ���� Ŭ������ �����ؼ� �����
		public Object key;
		public Object data;
		public Node next;

		public Node(Object newkey, Object newdata, Node ref) { // ��� Ŭ���� ������
			key = newkey;
			data = newdata;
			next = ref;
		}

		public Object getKey() {
			return key;
		}

		public Object getData() {
			return data;
		}
	} // end of Node class
	
	private int hash(K key) { // �ؽ��ڵ�
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public V get(K key) { // Ž�� ����
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) { // ���Ḯ��Ʈ Ž��
			if (key.equals(x.key)) {
				return (V) x.data; // Ž������
			}
		}
		return null; // Ž������
	}

	public void put(K key, V data) { // ���� ����
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) {
			if (key.equals(x.key)) { // �̹� key�� ������
				x.data = data; // ������ ������� ����
				return; // ����
			}
		}
		a[i] = new Node(key, data, a[i]); // ���� ����Ʈ�� ù ���� ���� (head�� ��)
		check_and_rehash();
	}// ó�� �ؽ����̺��� ���� �� �̹� null������ ���ΰ� �� �ʱ�ȭ�Ǿ� �־ null���� ���� �ȳ־��൵ ��
	 // �� ó�� ���� next�� null�ϰŰ� ���� �߰��Ǹ鼭 ��� �ڷ� �и�

	private void check_and_rehash() {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null) {
				for (Node x = a[i]; x != null; x = x.next) {
					cnt++; // ���̺� �� ������ �����ϴ� ������ ����
				}
			}
		}
		if ((double) cnt / (double) a.length > 0.75) {
			System.out.println("[check_and_rehash] ���̺��� ����� " + a.length + " ���� " + 2 * a.length + "�� �����մϴ�.");
			Node t[] = new Node[a.length * 2]; // 2�� ũ���� ���̺��� �غ� 
			M = a.length * 2;
			for (int i = 0; i < a.length; i++) {
				if (a[i] != null) {
					t[hash((K) a[i].getKey())] = a[i];
				}
			}
			a = t;
			return;
		} else if ((double) cnt / (double) a.length < 0.25 && a.length / 2 >= 5) {
			System.out.println("[check_and_rehash] ���̺��� ����� " + a.length + " ���� " + a.length / 2 + "�� �����մϴ�.");
			Node t[] = new Node[a.length / 2]; // 1/2 ũ���� ���̺��� �غ�
			M = a.length / 2;
			for (int i = 0; i < a.length; i++) {
				if (a[i] != null) {
					t[hash((K) a[i].getKey())] = a[i];
				}
			}
			a = t;
			return;
		}
		System.out.println("[check_and_rehash] ���̺��� ����� �������� �ʽ��ϴ�.");
	}

	public void delete(K key) {
		int hashVal = hash(key);
		if (a[hashVal].getKey().equals(key)) { 
			a[hashVal] = a[hashVal].next;
		}
		
		for (int i = 0; i < a.length; i++) {
			Node n = a[i];
			while (n != null) {
				Node t = n.next;
				if (t != null && t.getKey().equals(key)) {
					n.next = t.next;
					break;
				}
				n = n.next;
			}
		}
		check_and_rehash();
	}

	public void print() {
		System.out.println("�ؽ� ���̺� : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(i);
			if (a[i] != null) { // a[i]�� ���� null�� �ƴ� ��츸 
				Node n = a[i]; // a[i]�� ��带 n�� �ӽ����� 
				while (n != null) { // n�� null�� �ƴ� �� ������
					System.out.print("-->[" + n.getKey() + ", " + n.getData() + "]");
					n = n.next; // n�� ���� ��带 n�� ���� 
				}
			}
			System.out.println();
		}
	}
}