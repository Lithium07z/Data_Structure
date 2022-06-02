import java.util.LinkedList;
import java.util.List;

public class AdjListGraph {
	private List<Edge>[] adjList;
	
	public AdjListGraph() {
		buildGraph();
	}
	
	protected List<Edge>[] getAdjList() {
		return this.adjList;
	}
	
	private void buildGraph() {
		// 인접 행렬 구현 
		int[][] arr = { {0, 1, 1, 0},
					    {1, 0, 1, 1},
					    {1, 1, 0, 1},
					    {0, 1, 1, 0} };
		this.adjList = new List[4];
		for (int i = 0; i < 4; i++) {
			adjList[i] = new LinkedList<>();
			for (int j = 0; j < 4; j++) {
				if (arr[i][j] == 1) {
					Edge e = new Edge(j);
					adjList[i].add(e);
				}
			}
		}
		
		// 인접 리스트 구현 
		/*
		this.adjList = new List[4];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<>();
		}
		Edge edgeTo0 = new Edge(0);
		Edge edgeTo1 = new Edge(1);
		Edge edgeTo2 = new Edge(2);
		Edge edgeTo3 = new Edge(3);

		this.adjList[0].add(edgeTo1);
		this.adjList[0].add(edgeTo2);
		
		this.adjList[1].add(edgeTo0);
		this.adjList[1].add(edgeTo2);
		this.adjList[1].add(edgeTo3);
		
		this.adjList[2].add(edgeTo0);
		this.adjList[2].add(edgeTo1);
		this.adjList[2].add(edgeTo3);
		
		this.adjList[3].add(edgeTo1);
		this.adjList[3].add(edgeTo2);
		*/
	}
	
	
	public void printGraph() {
		System.out.println("Graph (AdjList): ");
		for (int i = 0; i < adjList.length; i++) {
			System.out.print("[" + i + "] => ");
			for (int j = 0; j < adjList[i].size(); j++) {
				System.out.print(adjList[i].get(j).adjvertex);
				if (j != adjList[i].size() - 1) {
					System.out.print(" => ");
				}
			}
			System.out.println();
		}
	}
}
