import java.util.*;

public class BFS {
	int N; // 그래프 정점의 수
	List<Edge>[] graph;
	private boolean[] visited; // BFS 수행 중 방문한 정점의 원소를 true로 만듬

	public BFS(List<Edge>[] adjList) {
		System.out.println("BFS 방문 순서 : ");
		N = adjList.length;
		graph = adjList;
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				bfs(i);
			}
		}
		System.out.println();
	}

	private void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[i] = true;
		q.add(i);
		while (!q.isEmpty()) {
			int j = q.remove();
			System.out.print(j + " ");
			for (Edge e : graph[j]) {
				if (!visited[e.adjvertex]) {
					visited[e.adjvertex] = true;
					q.add(e.adjvertex);
				}
			}
		}
	}
}
