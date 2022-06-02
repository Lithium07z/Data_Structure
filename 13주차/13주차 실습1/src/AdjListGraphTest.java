import java.util.LinkedList;
import java.util.List;

public class AdjListGraphTest {
	public static void main(String[] args) {
		AdjListGraph adListGraph = new AdjListGraph();
		
		adListGraph.printGraph();
		
		// Q2. DFS, Q3. BFS / 인접 행렬 구현, 출력 순서 일치X
		/*
		List<Edge>[] adjList1 = new List[10];
		int[][] arr = { {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
						{1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
						{1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
						{0, 1, 1, 0, 0, 0, 0, 0, 1, 1},
						{0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
						{0, 0, 0, 0, 1, 0, 1, 1, 0, 0},
						{0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
						{0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
						{0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 1, 0, 0, 0, 0, 0, 0} };
		for (int i = 0; i < 10; i++) {
			adjList1[i] = new LinkedList<>();
			for (int j = 0; j < 10; j++) {
				if (arr[i][j] == 1) {
					Edge e = new Edge(j);
					adjList1[i].add(e);
				}
			}
		}
		*/
		// Q2. DFS, Q3. BFS / 인접 리스트 구현 
		List<Edge>[] adjList1 = new List[10];
		for (int i = 0; i < adjList1.length; i++) {
			adjList1[i] = new LinkedList<>();
		}
		Edge edgeTo0 = new Edge(0);
		Edge edgeTo1 = new Edge(1);
		Edge edgeTo2 = new Edge(2);
		Edge edgeTo3 = new Edge(3);
		Edge edgeTo4 = new Edge(4);
		Edge edgeTo5 = new Edge(5);
		Edge edgeTo6 = new Edge(6);
		Edge edgeTo7 = new Edge(7);
		Edge edgeTo8 = new Edge(8);
		Edge edgeTo9 = new Edge(9);
		
		
		adjList1[0].add(edgeTo2);
		adjList1[0].add(edgeTo1);
		
		adjList1[1].add(edgeTo3);
		adjList1[1].add(edgeTo0);
		
		adjList1[2].add(edgeTo3);
		adjList1[2].add(edgeTo0);
		
		adjList1[3].add(edgeTo9);
		adjList1[3].add(edgeTo8);
		adjList1[3].add(edgeTo2);
		adjList1[3].add(edgeTo1);
		
		adjList1[4].add(edgeTo5);
		
		adjList1[5].add(edgeTo7);
		adjList1[5].add(edgeTo6);
		adjList1[5].add(edgeTo4);
		
		adjList1[6].add(edgeTo7);
		adjList1[6].add(edgeTo5);
		
		adjList1[7].add(edgeTo6);
		adjList1[7].add(edgeTo5);
		
		adjList1[8].add(edgeTo3);
		
		adjList1[9].add(edgeTo3);
		
		DFS dfs = new DFS(adjList1);
		BFS bfs = new BFS(adjList1);
		
		// Q4. 위상 정렬 / 인접 행렬 구현
		List<Integer>[] adjList2 = new List[9];
		int[][] arr = { {0, 1, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 1, 1, 0, 0, 0, 0},
						{1, 1, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 1, 0, 0},
						{0, 0, 0, 0, 0, 1, 0, 0, 0},
						{0, 0, 0, 1, 0, 0, 0, 1, 0},
						{0, 0, 0, 0, 0, 0, 0, 1, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 1},
						{0, 0, 0, 0, 0, 0, 0, 0, 0} };
		for (int i = 0; i < 9; i++) {
			adjList2[i] = new LinkedList<>();
			for (int j = 0; j < 9; j++) {
				if (arr[i][j] == 1) {
					adjList2[i].add(j);
				}
			}
		}
		
		// Q4. 위상 정렬 / 인접 리스트 구현
		/*
		List<Integer>[] adjList2 = new List[9];
		for (int i = 0; i < adjList2.length; i++) {
			adjList2[i] = new LinkedList<>();
		}
		
		adjList2[0].add(1);
		
		adjList2[1].add(4);
		adjList2[1].add(3);
		
		adjList2[2].add(1);
		adjList2[2].add(0);
		
		adjList2[3].add(6);
		
		adjList2[4].add(5);
		
		adjList2[5].add(3);
		adjList2[5].add(7);
		
		adjList2[6].add(7);
		
		adjList2[7].add(8);
		*/
		TopologicalSort tpgSort = new TopologicalSort(adjList2);
		System.out.println("위상 정렬 : ");
		System.out.println(tpgSort.tsort());
		
	}
}

