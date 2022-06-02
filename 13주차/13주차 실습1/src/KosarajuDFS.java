import java.util.LinkedList;
import java.util.List;

public class KosarajuDFS {
	int N; // �׷��� ������ ��
	List<Edge>[] adjListReverse;
	private boolean[] visited; // DFS ���� �� �湮�� ������ true�� ����
	private List<Integer>[] scc; // ������ ���е��� ������ ����Ʈ 
	private int cnt = 0;
	
	public KosarajuDFS(List<Edge>[] adjListReverse, List<Integer> topological) { // �������� �׷����� �������� ����� ���� 
		N = adjListReverse.length; // �׷��� ���� ���� �ʱ�ȭ
		this.adjListReverse = adjListReverse; // KosarajuDFS Ŭ������ adjListReverse�� �����ڷ� ���� �׷����� �ѱ�
		visited = new boolean[N]; 
		scc = new List[topological.size()]; // ������ ������ ������ ��� ������ ���� ������ ��캸�� Ŭ �� �����Ƿ� ������ ������ �ʱ�ȭ
		for (int i = 0; i < N; i++) {
			visited[i] = false; // �迭 �ʱ�ȭ
		}
		for (int i = 0; i < N; i++) {
			if (!visited[topological.get(i)]) {
				scc[cnt] = new LinkedList<>(); // List�迭 �� ��Ҹ��� LinkedList �ʱ�ȭ�ؼ� �־���
				dfs(topological.get(i)); // �����Ἲ�г����� ��� ����Ǳ� ������ dfs ���ȣ���߿� ���� ���� ���� ���� ���ȣ���� ������ 
				cnt++; // cnt ����        // ���� ȣ���̾��� ������� �´ٸ� �����Ἲ�� Ž���� ����� ���� 
			}
		}
		System.out.println("�� ���� ���� : ");
		for (int i = 0; i < scc.length; i++) {
			if (scc[i] == null) { // null�� �κк��ʹ� ���� ������ ����
				break;
			}
			System.out.print("[" + i + "] ");
			for (int j = 0; j < scc[i].size(); j++) {
				if (scc[i] != null) { // scc�迭 �� null�� �κ��� ���� 
					System.out.print(scc[i].get(j)); // scc�迭�� ����� ����Ʈ �� �ݺ��ϸ� ��� 			
				}
				if (j < scc[i].size() - 1) { // , �־��ֱ� 
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}
	
	private void dfs(int i) {
		visited[i] = true;
		scc[cnt].add(i); // ����Ʈ�� �� �߰� 
		for (Edge e : this.adjListReverse[i]) {
			if (!visited[e.adjvertex]) {
				dfs(e.adjvertex);
			}
		}
	}
}