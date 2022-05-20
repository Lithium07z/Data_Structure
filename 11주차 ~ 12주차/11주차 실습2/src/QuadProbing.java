
public class QuadProbing<K, V> {
	private int N = 0, M = 13; // ���̺� ����� �׸� ��, ���̺� ũ�� < �׻� �Ҽ��� �����ؾ� �� 
	private K[] a = (K[]) new Object[M]; // key ���� �����ϴ� ���̺� / Key���� �ؽ������� �ٲ�� �ϴϱ�
	private V[] d = (V[]) new Object[M]; // value ���� �����ϴ� ���̺�
	private int hash(K key) { // �ؽ��ڵ�
		return (key.hashCode() & 0x7fffffff) % M; // ������ ����
		// 0x7fffffff = 011111.... < And �����̹Ƿ� ù ��° sign���� 0���� �ٲ� = ����� ��
	}
	
	public void put(K key, V data) { 
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		do {
			if (a[i] == null) { // ���� ��ġ �߰�
				a[i] = key; // key�� �ؽ����̺� ���� 
				d[i] = data; N++; // key���� ������ ���� 
				return;
			}
			if (a[i].equals(key)) { // �̹� key ����
				d[i] = data; // data �����͸� ���� 
				return;
			}
			i = (initialpos + j * j++) % M; // ���� ũ�Ⱑ ���� ũ��� ������ 
		} while (N < M);
	}
	
	public V get(K key) {
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		while (a[i] != null) { // a[i]�� empty�� �ƴϸ�
			if (a[i].equals(key)) { // Ž�� ����
				return d[i];
			}
			i = (initialpos + j * j++) % M; // ���� ũ�Ⱑ ���� ũ��� ������ 
		}
		return null; // Ž�� ���� 
	}
	
	public void print() {
		System.out.println("�ؽ� ���̺� : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print("\t" + i);
		}
		System.out.println();
		for (int i = 0; i < d.length; i++) {
			System.out.print("\t" + a[i]);
		}
		System.out.println();
	}
}