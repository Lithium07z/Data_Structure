import java.util.LinkedList;
import java.util.List;

public class Kosaraju extends AdjListGraphExt {
	private List<Edge>[] adjListReverse; // this.adjList에 해당하는 그래프의 역방향 그래프를 인접리스트 형태로 저장하는 멤버 변수
	private List<Edge>[] adjList;
	private List<Integer> topological;
	
	public Kosaraju(List<Edge>[] adjList) {
		super.setAdjList(adjList); // AdjListGraphExt의 adjList를 생성자로 받은 adjList로 초기화 해줌 
		super.getReverse(); // 생성자로 받은 adjList를 거꾸로 뒤집음 
		this.adjList = adjList; // 생성자로 받은 adjList로 Kosaraju클래스의 adjList 초기화
		this.adjListReverse = super.getAdjListReverse(); // 생성자로 받은 adjList를 뒤집은 AdjListReveres를 AdjListGraphExt에서 받음
	}

	public void reverseDFS() {
		List<Integer>[] adjListInt = new List[adjList.length]; // 위상정렬은 Integer 리스트라서 List타입으로 바꿔줌
		for (int i = 0; i < adjListReverse.length; i++) {
			adjListInt[i] = new LinkedList<Integer>();
			for (int j = 0; j < adjList[i].size(); j++) {
				adjListInt[i].add(adjList[i].get(j).adjvertex); // Edge의 adjvertex가 곧 Edge와 같으니 리스트에 추가 
			}
		}
		TopologicalSort tpgSort = new TopologicalSort(adjListInt); // Integer타입으로 바꾼 리스트를 TopologicalSort클래스로 보냄 
		topological = tpgSort.tsort(); // 위상정렬된 결과를 Kosaraju 클래스의 topological 리스트에 넣음
		KosarajuDFS kDFS = new KosarajuDFS(adjListReverse, topological); // 뒤집어진 리스트와 위상정렬 결과를 kDFS로 보냄 
	}
}
