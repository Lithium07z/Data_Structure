
public class Chaining<K, V> {
	private int M = 13; // ���̺� ũ��
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

		public Object getkey() {
			return key;
		}

		public Object getData() {
			return data;
		}
	} // end of Noed class

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
	}// ó�� �ؽ����̺��� ���� �� �̹� null������ ���ΰ� �� �ʱ�ȭ�Ǿ� �־ null���� ���� �ȳ־��൵ ��
	 // �� ó�� ���� next�� null�ϰŰ� ���� �߰��Ǹ鼭 ��� �ڷ� �и�
	
	public boolean findTwoNum(int[] arr, int sum) {
		for (int i = 0; i < a.length; i++) { // ���� �� �ؽ����̺� �ʱ�ȭ 
			a[i] = null;
		}
		for (int z : arr) {
			K diff = (K)(Object)(sum - z); // sum - z 
			if (get(diff) != null) {
				return true;
			} else {
				put((K)(Object)z, (V)(Object)z);
			}
		}
		return false;
	}
	
	public void print() {
		System.out.println("�ؽ� ���̺� : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(i);
			if (a[i] != null) {
				Node n = a[i];
				while (n != null) {
					System.out.print("-->[" + n.getkey() + ", " + n.getData() + "]");
					n = n.next;
				}
			}
			System.out.println();
		}
	}
}