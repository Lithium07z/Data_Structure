
public class BellmanFord {
	public static final int INF = Integer.MAX_VALUE;
	private int D[];
	private int previous[]; // ��� ������ ����
	private int N;
	
	public BellmanFord(int numOfVertices) { // ������
		N = numOfVertices;
		D = new int[N]; // �ִܰŸ� ����
		previous = new int[N];  // �ִܰ�� �����ϱ� ����
	}
	
	public void shortestPath(int s, int adjMatrix[][]) {
		int chk = 0; // ���� �ݺ��� ���� �ݺ��� 
		for (int i = 0; i < N; i++) {
			D[i] = INF; // �ʱ�ȭ
		}
		D[s] = 0; // �ʱⰪ �ʱ�ȭ
		previous[s] = 0; // �ʱⰪ �ʱ�ȭ 
		for (int k = 0; k < N - 1; k++) { // �־ǰ�� N - 1�� �ݺ�
			if (k != 0 && chk == 0) { // ���� ���� �ݺ��� ����� ���ٸ� �� �̻� �ݺ����� ������ ���� ����� �����״�
				break; // �ݺ��� ���� 
			}
			chk = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (adjMatrix[i][j] != INF) {
						if (D[j] > D[i] + adjMatrix[i][j]) {
							D[j] = D[i] + adjMatrix[i][j]; // ������ȭ
							previous[j] = i;
							chk++;
						}
					}
				}
			}
		}
	}
	
	public void printPath(int s) { // ��� ���
		System.out.println("���� 0���κ����� �ִܰŸ�");
		for (int i = 1; i < D.length; i++) {
			if (D[i] == Integer.MAX_VALUE) {
				System.out.println("0��" + i + "���̿� ��� ����.");
			} else {
				System.out.println("[0, " + i + "] = " + D[i]);
			}
		}
		System.out.print("���� 0���κ����� �ִܰ��\n");
		for (int i = 1; i < N; i++) {
			int back = i;
			System.out.print(back);
			while (back != 0) {
				System.out.print(" <- " + previous[back]);
				back = previous[back];
			}
			System.out.println();
		}
	}
}
	
	
