
public class LinearProbing<K, V> {
	private int M = 13; // ���̺� ũ��, �׻� �Ҽ��� �����ؾ� �� 
	private K[] a = (K[]) new Object[M]; // key ���� �����ϴ� ���̺� / Key���� �ؽ������� �ٲ�� �ϴϱ�
	private V[] d = (V[]) new Object[M]; // value ���� �����ϴ� ���̺�
	private int hash(K key) { // �ؽ��ڵ�
		return (key.hashCode() & 0x7fffffff) % M; // ������ ����
		// 0x7fffffff = 011111.... < And �����̹Ƿ� ù ��° sign���� 0���� �ٲ� = ����� ��
	}
	
	public void put(K key, V data) { // ���Կ���
		int initialpos = hash(key); // key������ hash�ڵ� ����
		int i = initialpos, j = 1;
		do {
			if (a[i] == null) { // null = ����� = ������ ��ġ 
				a[i] = key; // key�� �ؽ����̺� ����
				d[i] = data; // key���� �����͸� ������ �ε����� ����
				return;
			}
			if (a[i].equals(key)) { // key�� ���Ƽ� hash�ڵ尡 ���� ���
				d[i] = data; // �����͸� ����, �����
				return;
			}
			i = (initialpos + j++) % M; // key�� �ٸ����� hash�ڵ尡 �쿬�� ���� ��� 
			// j��°, ���� ��ġ�� �̵��� �迭 ũ��(�Ҽ�)�� ����
		} while(i != initialpos); // i�� initialpos�� ���� = �ʱ���ġ���� ���ƿ����� ������ ������ ������.
		// ��� ���� ������ ��ã���� j�� �����ؼ� M�� ������, ���� ���� ���� i�� �������� �ݺ��� Ż�� 
	}
	
	public V get(K key) { // Ž�� ���� 
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		do {
			if(a[i].equals(key)) { // ã�� Ű�� �����ϸ�
				return d[i]; // �ش� �� ���� 
			}
			i = (initialpos + j++) % M; 
		} while (a[i] != null && i != initialpos);
		// a[i] == null�̸� stop < ��ã��, i == initialpos�� ó����ġ�� ���ƿ��� stop < ��ã��
		return null;
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


