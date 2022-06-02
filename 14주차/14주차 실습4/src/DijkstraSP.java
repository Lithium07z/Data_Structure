import java.util.List;

public class DijkstraSP {
	public int N; // 그래프 정점의 갯수
	List<Edge>[] graph;
	public int[] previous; // 최단 경로상 이전 정점을 기록하기 위해

	public DijkstraSP(List<Edge>[] adjList) {
		N = adjList.length; // 인접 리스트 크기 초기화
		previous = new int[N]; // 이전 정점을 기록할 previous도 리스트 크기만큼 초기화
		graph = adjList; // 생성자로 받은 리스트를 graph로 초기화
	}
	
	public int[] shortestPath(int s) {
		boolean[] visited = new boolean[N];
		int[] D = new int[N];
		for (int i = 0; i < N; i++) { // 초기화
			visited[i] = false;
			previous[i] = -1;
			D[i] = Integer.MAX_VALUE;
		}
		previous[s] = 0; // 시작점 s의 관련 정보 초기화
		D[s] = 0; // 시작점은 가중치 없음 
		for (int k = 0; k < N; k++) { // 방문 안된 정점들 중에서 
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if ((!visited[j]) && (D[j] < min)) {
					min = D[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;
			for (Edge e : graph[minVertex]) { // minVertex에 인접한 각 정점에 대해 
				if (!visited[e.adjvertex]) {
					int currentDist = D[e.adjvertex];
					int newDist = D[minVertex] + e.weight;
					if (newDist < currentDist) {
						D[e.adjvertex] = newDist; // 간선완화
						previous[e.adjvertex] = minVertex; // 최종 최단경로를 "역방향으로 추출"
					}
				}
			}
		}
		return D;
	}
}
