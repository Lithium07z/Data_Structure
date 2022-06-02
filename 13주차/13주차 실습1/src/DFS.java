import java.util.List;

public class DFS {
	int N; // 그래프 정점의 수
	List<Edge>[] graph;
	private boolean[] visited; // DFS 수행 중 방문한 정점을 true로 만듬

	public DFS(List<Edge>[] adjList) { // 생성자
		System.out.println("DFS 방문 순서 : ");
		N = adjList.length;
		graph = adjList;
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			visited[i] = false; // 배열 초기화
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
