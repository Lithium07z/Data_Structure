import java.util.LinkedList;
import java.util.List;

public class AdjListGraphExt extends AdjListGraph {
	private List<Edge>[] adjListReverse; // this.adjList에 해당하는 그래프의 역방향 그래프를 인접리스트 형태로 저장하는 멤버 변수
	private List<Edge>[] adjList;
	
	public AdjListGraphExt() {
		super();
		this.adjList = super.getAdjList();
	}
	
	public void setAdjList(List<Edge>[] adjList) {
		this.adjList = adjList;
		
	}
	
	public List<Edge>[] getAdjListReverse() {
		return this.adjListReverse;
	}
	
	public void getReverse() { // 멤버 변수인 this.adjList 그래프의 역방향 그래프를 this.adjListReverse에 저장하는 메소드
		this.adjListReverse = new List[adjList.length]; // adjListReverse는 뒤집기만 한거라 adjList와 크기가 같음 
		int[][] arr = new int[adjList.length][adjList.length]; // 인접 행렬 선언
		for (int i = 0; i < adjList.length; i++) {
			for (int j = 0; j < adjList[i].size(); j++) { // adjList의 인덱스 마다 연결된 리스트의 값이 곧 인덱스 정점과 연결된 다른 정점이므로
				int num = adjList[i].get(j).adjvertex; // 정점 i에 연결된 값들
				arr[i][num] = 1; // 정점 i와 연려된 값 num의 위치가 1이므로 1 넣어줌 
			}
		}
		for (int i = 0; i < adjList.length; i++) {
			for (int j = i + 1; j < adjList.length; j++) { // j가 0부터 시작하면 같은 위치를 바꿔치기함 i + 1부터 시작 
				int temp = arr[i][j];
				arr[i][j] = arr[j][i]; // 역방향 그래프를 그려야 하므로 행과 열의 위치를 바꿔치기
				arr[j][i] = temp;
			}
		}
		for (int i = 0; i < adjList.length; i++) { // 다시 리스트로 만들어주기 
			adjListReverse[i] = new LinkedList<>();
			for (int j = 0; j < adjList.length; j++) {
				if (arr[i][j] == 1) { // 1인 부분이 곧 두 정점이 연결된 부분이니까
					Edge e = new Edge(j); // 정점 i를 기준으로 j정점을 엣지로 만들어서
					adjListReverse[i].add(e); // 리스트에 추가 
				}
			}
		}
	}
	
	public void printGraphReverse() {
		System.out.println("GraphReverse (AdjList): ");
		for (int i = 0; i < adjListReverse.length; i++) {
			System.out.print("[" + i + "] => ");
			for (int j = 0; j < adjListReverse[i].size(); j++) {
				System.out.print(adjListReverse[i].get(j).adjvertex);
				if (j != adjListReverse[i].size() - 1) {
					System.out.print(" => ");
				}
			}
			System.out.println();
		}
	}
}
