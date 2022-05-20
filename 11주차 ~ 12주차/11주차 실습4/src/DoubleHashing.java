
public class DoubleHashing<K, V> {
	private int N = 0, M = 13; // ���̺� ����� �׸� ��, ���̺� ũ�� < �׻� �Ҽ��� �����ؾ� �� 
	private K[] a = (K[]) new Object[M]; // key ���� �����ϴ� ���̺� / Key���� �ؽ������� �ٲ�� �ϴϱ�
	private V[] dt = (V[]) new Object[M]; // value ���� �����ϴ� ���̺�

	private int hash(K key) { // �ؽ��ڵ�
		return (key.hashCode() & 0x7fffffff) % M; // ������ ����
		// 0x7fffffff = 011111.... < And �����̹Ƿ� ù ��° sign���� 0���� �ٲ� = ����� ��
	}
	
	public void put(K key, V data) {
		int initialpos = hash(key);
		int i = initialpos;
		int j = 1;
		int d = (7 - (int)key % 7); // �� ��° �ؽ��Լ�, d = 7 - (int)key % 7
		do {
			if (a[i] == null) { // ���� ��ġ
				a[i] = key; // key�� �ؽ����̺� ����
				dt[i] = data; // key ���� ������ ���� 
				N++; // �׸�� ���� 
				return;
			}
			if (a[i].equals(key)) { // ���� key�� ���� 
				dt[i] = data; // ������ ������� ���� 
				return;
			}
			i = (initialpos + j * d) % M; // �� ��° �ؽ��Լ��� �̿��ؼ� ����ȭ ����
			j++;
		} while (N < M);
	}
	
	public V get(K key) {
		int initialpos = hash(key);
		int i = initialpos;
		int j = 1;
		int d = (7 - (int)key % 7); // �� ��° �ؽ��Լ�, d = 7 - (int)key % 7
		while (a[i] != null) {
			if (a[i].equals(key)) {
				return dt[i];
			}
			i = (initialpos + j * d) % M; // �� ��° �ؽ��Լ��� �̿��ؼ� ����ȭ ����
			j++;
		}
		return null;
	}
	
	public void print() {
		System.out.println("�ؽ� ���̺� : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print("\t" + i);
		}
		System.out.println();
		for (int i = 0; i < dt.length; i++) {
			System.out.print("\t" + a[i]);
		}
		System.out.println();
	}
}
