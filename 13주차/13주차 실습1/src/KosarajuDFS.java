import java.util.LinkedList;
import java.util.List;

public class KosarajuDFS {
	int N; // 그래프 정점의 수
	List<Edge>[] adjListReverse;
	private boolean[] visited; // DFS 수행 중 방문한 정점을 true로 만듬
	private List<Integer>[] scc; // 강연결 성분들을 저장할 리스트 
	private int cnt = 0;
	
	public KosarajuDFS(List<Edge>[] adjListReverse, List<Integer> topological) { // 뒤집어진 그래프와 위상정렬 결과를 받음 
		N = adjListReverse.length; // 그래프 정점 갯수 초기화
		this.adjListReverse = adjListReverse; // KosarajuDFS 클래스의 adjListReverse에 생성자로 받은 그래프를 넘김
		visited = new boolean[N]; 
		scc = new List[topological.size()]; // 강연결 성분의 갯수는 모든 정점이 단일 정점인 경우보다 클 수 없으므로 정점의 개수로 초기화
		for (int i = 0; i < N; i++) {
			visited[i] = false; // 배열 초기화
		}
		for (int i = 0; i < N; i++) {
			if (!visited[topological.get(i)]) {
				scc[cnt] = new LinkedList<>(); // List배열 각 요소마다 LinkedList 초기화해서 넣어줌
				dfs(topological.get(i)); // 강연결성분끼리는 모두 연결되기 때문에 dfs 재귀호출중에 끊길 일이 없음 만약 재귀호출이 끝나서 
				cnt++; // cnt 증가        // 최초 호출이었던 여기까지 온다면 강연결성분 탐색이 종료된 것임 
			}
		}
		System.out.println("강 연결 성분 : ");
		for (int i = 0; i < scc.length; i++) {
			if (scc[i] == null) { // null인 부분부터는 값이 없으니 종료
				break;
			}
			System.out.print("[" + i + "] ");
			for (int j = 0; j < scc[i].size(); j++) {
				if (scc[i] != null) { // scc배열 중 null인 부분은 제외 
					System.out.print(scc[i].get(j)); // scc배열에 연결된 리스트 값 반복하며 출력 			
				}
				if (j < scc[i].size() - 1) { // , 넣어주기 
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}
	
	private void dfs(int i) {
		visited[i] = true;
		scc[cnt].add(i); // 리스트에 값 추가 
		for (Edge e : this.adjListReverse[i]) {
			if (!visited[e.adjvertex]) {
				dfs(e.adjvertex);
			}
		}
	}
}