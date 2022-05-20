import java.util.Random;

public class RandProbing<K, V> {
	private int N = 0, M = 13; // ���̺� ����� �׸� ��, ���̺� ũ�� < �׻� �Ҽ��� �����ؾ� �� 
	private K[] a = (K[]) new Object[M]; // key ���� �����ϴ� ���̺� / Key���� �ؽ������� �ٲ�� �ϴϱ�
	private V[] d = (V[]) new Object[M]; // value ���� �����ϴ� ���̺�

	private int hash(K key) { // �ؽ��ڵ�
		return (key.hashCode() & 0x7fffffff) % M; // ������ ����
		// 0x7fffffff = 011111.... < And �����̹Ƿ� ù ��° sign���� 0���� �ٲ� = ����� ��
	}
	
	public void put(K key, V data) {
		int initialpos = hash(key);
		int i = initialpos;
		Random rand = new Random(); // �����Լ� ȣ��
		rand.setSeed(10); // �����Լ��� �õ���ڸ� 10���� ����
		do {
			if (a[i] == null) {
				a[i] = key;
				d[i] = data;
				N++; // �׸� �� ���� 
				return;
			}
			if (a[i].equals(key)) {
				d[i] = data;
				return;
			}
			i = (initialpos + rand.nextInt(1000)) % M; // �����Լ��� �̿��ؼ� ���� ��ġ ���
		} while (N < M); // ���� ������ ������ ���̺� ũ�⺸�� ������������
	}
	public V get(K key) {
		Random rand = new Random(); // �����Լ� ȣ��
		rand.setSeed(10); // �����Լ��� �õ���ڸ� 10���� ����
		int initialpos = hash(key);
		int i = initialpos;
		while (a[i] != null) {
			if (a[i].equals(key)) { // Ž������
				return d[i];
			}
			i = (initialpos + rand.nextInt(1000)) % M; // �����Լ��� �̿��ؼ� ���� ��ġ ���
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
