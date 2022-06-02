import java.util.LinkedList;
import java.util.List;

public class MyGraphTest {
	public static void main(String[] args) {
		MyGraph graph = new MyGraph();
		
		// 인접 리스트로 구현 
		List<Edge>[] adjList = new List[8];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<>();
		}
		Edge edgeTo0_1 = new Edge(0, 1); // 반대편 정점이 0이고 가중치가 1인 간선
		Edge edgeTo0_2 = new Edge(0, 2);
		
		Edge edgeTo1_1 = new Edge(1, 1);
		Edge edgeTo1_3 = new Edge(1, 3);
		Edge edgeTo1_4 = new Edge(1, 4);
		Edge edgeTo1_6 = new Edge(1, 6);
		
		Edge edgeTo2_1 = new Edge(2, 1);
		Edge edgeTo2_2 = new Edge(2, 2);
		Edge edgeTo2_4 = new Edge(2, 4);
		
		Edge edgeTo3_2 = new Edge(3, 2);
		Edge edgeTo3_3 = new Edge(3, 3);
		Edge edgeTo3_5 = new Edge(3, 5);
		
		Edge edgeTo4_1 = new Edge(4, 1);
		Edge edgeTo4_2 = new Edge(4, 2);
		Edge edgeTo4_5 = new Edge(4, 5);
		
		Edge edgeTo5_1 = new Edge(5, 1);
		Edge edgeTo5_6 = new Edge(5, 6);
		Edge edgeTo5_9 = new Edge(5, 9);
		
		Edge edgeTo6_1 = new Edge(6, 1);
		Edge edgeTo6_2 = new Edge(6, 2);
		
		Edge edgeTo7_1 = new Edge(7, 1);
		Edge edgeTo7_2 = new Edge(7, 2);
		Edge edgeTo7_9 = new Edge(7, 9);
		
		adjList[0].add(edgeTo1_1);
		adjList[0].add(edgeTo3_2);
		
		adjList[1].add(edgeTo0_1);
		adjList[1].add(edgeTo2_4);
		adjList[1].add(edgeTo3_3);
		adjList[1].add(edgeTo4_1);
		adjList[1].add(edgeTo5_6);
		
		adjList[2].add(edgeTo1_4);
		adjList[2].add(edgeTo5_1);
		adjList[2].add(edgeTo6_1);
		adjList[2].add(edgeTo7_2);
		
		adjList[3].add(edgeTo0_2);
		adjList[3].add(edgeTo1_3);
		adjList[3].add(edgeTo4_5);
		
		adjList[4].add(edgeTo1_1);
		adjList[4].add(edgeTo3_5);
		adjList[4].add(edgeTo6_2);
		
		adjList[5].add(edgeTo1_6);
		adjList[5].add(edgeTo2_1);
		adjList[5].add(edgeTo7_9);
		
		adjList[6].add(edgeTo2_1);
		adjList[6].add(edgeTo4_2);
		adjList[6].add(edgeTo7_1);
		
		adjList[7].add(edgeTo2_2);
		adjList[7].add(edgeTo5_9);
		adjList[7].add(edgeTo6_1);
		
		System.out.println("[Task 1]");
		graph.print(adjList);
		graph.print(graph.getAdjMatrixFromAdjList(adjList));
		
		// 인접 행렬로 구현
		int[][] arr = {{0, 1, 0, 2, 0, 0, 0, 0}, 
					   {1, 0, 4, 3, 1, 6, 0, 0},
					   {0, 4, 0, 0, 0, 1, 1, 2},
					   {2, 3, 0, 0, 5, 0, 0, 0},
					   {0, 1, 0, 5, 0, 0, 2, 0},
					   {0, 6, 1, 0, 0, 0, 0, 9},
					   {0, 0, 1, 0, 2, 0, 0, 1},
					   {0, 0, 2, 0, 0, 9, 1, 0}};

		System.out.println("[Task 2]");
		graph.print(arr);
		graph.print(graph.getAdjListFromAdjMatrix(arr));
	}
}
