import java.util.List;

public class PrimMST {
	int N; // �׷��� ������ ��
	List<Edge>[] graph;
	
	public PrimMST(List<Edge>[] adjList) {
		N = adjList.length;
		graph = adjList;
	}
	
	public int[] mst (int s) { // Prim �˰���, s�� ��������
		boolean[] visited = new boolean[N]; // �湮�� ������ true��, true�� �ȴٸ� �ּҽ��忡 �߰��Ȱ���
		int[] D = new int[N];  // �ּҽ���Ʈ���� ���� ����ġ
		int[] previous = new int[N]; // �ּҽ���Ʈ���� �������� Ȯ���� �� �ٸ� �� (Ʈ����)����
		int sum = 0;
		for (int i = 0; i < N; i++) { // �ʱ�ȭ
			visited[i] = false;
			previous[i] = -1;
			D[i] = Integer.MAX_VALUE; // D[i]�� �ִ����� �ʱ�ȭ
		}
		previous[s] = 0; // ó������ Ž���� ���ؼ� ������ �����Ƿ� 0���� �ʱ�ȭ 
		D[s] = 0; // ������ġ���� ������ġ���� �Ÿ��� 0�̹Ƿ� 0���� �ʱ�ȭ 
		for (int k = 0; k < N; k++) { // �湮���� ���� �������� D���ҵ� �߿��� �ּڰ��� ���� minVertex ã��
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if ((!visited[j]) && (D[j] < min)) {
					min = D[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;
			for (Edge i : graph[minVertex]) { // minVertex�� ������ �� ������ D�� ���� ����
				if (!visited[i.adjvertex]) { // Ʈ���� ���� ���Ծȵ� �����̸� 
					int currentDist = D[i.adjvertex];
					int newDist = i.weight;
					if (newDist < currentDist) {
						D[i.adjvertex] = newDist; // minVertex�� ����� �������� D���� ����
						previous[i.adjvertex] = minVertex; // Ʈ�� ���� ������ ����
					}
				}
			}
		}
		System.out.println("�ּҽ���Ʈ�� ���� : ");
		for (int i = 0; i < previous.length; i++) {
			if (i == s && previous[i] == 0) { // ���� �ʱ�ȭ �� �߰��� ���� ������ ����
				continue;
			}
			System.out.print("(" + i + "," + previous[i] + ") ");
		}
		System.out.print("\n�ּҽ���Ʈ���� ���� ����ġ �� = ");
		for (int value : D) {
			sum += value;
		}
		System.out.println(sum);
		return previous; // �ּҽ���Ʈ�� ���� ���� ���� 
	}
}
