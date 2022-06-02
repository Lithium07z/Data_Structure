import java.util.List;

public class PrimMST {
	int N; // 그래프 정점의 수
	List<Edge>[] graph;
	
	public PrimMST(List<Edge>[] adjList) {
		N = adjList.length;
		graph = adjList;
	}
	
	public int[] mst (int s) { // Prim 알고리즘, s는 시작정점
		boolean[] visited = new boolean[N]; // 방문한 정점은 true로, true가 된다면 최소신장에 추가된것임
		int[] D = new int[N];  // 최소신장트리의 간선 가중치
		int[] previous = new int[N]; // 최소신장트리의 간선으로 확정될 때 다른 쪽 (트리의)끝점
		int sum = 0;
		for (int i = 0; i < N; i++) { // 초기화
			visited[i] = false;
			previous[i] = -1;
			D[i] = Integer.MAX_VALUE; // D[i]를 최댓값으로 초기화
		}
		previous[s] = 0; // 처음에는 탐색을 안해서 끝점이 없으므로 0으로 초기화 
		D[s] = 0; // 시작위치에서 시작위치로의 거리는 0이므로 0으로 초기화 
		for (int k = 0; k < N; k++) { // 방문하지 않은 정점들의 D원소들 중에서 최솟값을 가진 minVertex 찾기
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if ((!visited[j]) && (D[j] < min)) {
					min = D[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;
			for (Edge i : graph[minVertex]) { // minVertex에 인접한 각 정점의 D의 원소 갱신
				if (!visited[i.adjvertex]) { // 트리에 아직 포함안된 정점이면 
					int currentDist = D[i.adjvertex];
					int newDist = i.weight;
					if (newDist < currentDist) {
						D[i.adjvertex] = newDist; // minVertex와 연결된 정점들의 D원소 갱신
						previous[i.adjvertex] = minVertex; // 트리 간선 추출을 위해
					}
				}
			}
		}
		System.out.println("최소신장트리 간선 : ");
		for (int i = 0; i < previous.length; i++) {
			if (i == s && previous[i] == 0) { // 최초 초기화 때 추가된 시작 정점은 제외
				continue;
			}
			System.out.print("(" + i + "," + previous[i] + ") ");
		}
		System.out.print("\n최소신장트리의 간선 가중치 합 = ");
		for (int value : D) {
			sum += value;
		}
		System.out.println(sum);
		return previous; // 최소신장트리 간선 정보 리턴 
	}
}
