import java.util.List;

public class DFS {
	int N; // �׷��� ������ ��
	List<Edge>[] graph;
	private boolean[] visited; // DFS ���� �� �湮�� ������ true�� ����

	public DFS(List<Edge>[] adjList) { // ������
		System.out.println("DFS �湮 ���� : ");
		N = adjList.length;
		graph = adjList;
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			visited[i] = false; // �迭 �ʱ�ȭ
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}
		System.out.println();
	}
	
	private void dfs(int i) {
		visited[i] = true;
		System.out.print(i + " ");
		for (Edge e : graph[i]) {
			if (!visited[e.adjvertex]) {
				dfs(e.adjvertex);
			}
		}
	}
}
