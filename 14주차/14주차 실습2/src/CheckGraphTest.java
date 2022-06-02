import java.util.LinkedList;
import java.util.List;

public class CheckGraphTest {
	public static void main(String[] args) {
		CheckGraph chGraph = new CheckGraph();

		// [Task 1]인접 행렬로 구현
		System.out.println("[Task 1]");
		int[][] adjmat1 = {{0, 2, 3, 0},
						   {7, 0, 0, 4},
						   {6, 0, 0, 9},
						   {0, 1, 3, 0}};
		
		System.out.println(chGraph.isReverseSame(adjmat1));
		
		// [Task 1]인접 리스트로 구현
		List<Edge>[] adjlist1 = new List[4];
		for (int i = 0; i < adjlist1.length; i++) {
			adjlist1[i] = new LinkedList<>(); 
		}
		
		Edge edge1_6 = new Edge(1, 6);
		Edge edge1_7 = new Edge(1, 7);
		
		Edge edge2_1 = new Edge(2, 1);
		Edge edge2_2 = new Edge(2, 2);
		
		Edge edge3_3 = new Edge(3, 3);
		
		Edge edge4_4 = new Edge(4, 4);
		Edge edge4_9 = new Edge(4, 9);
		
		adjlist1[0].add(edge2_2);
		adjlist1[0].add(edge3_3);
		
		adjlist1[1].add(edge1_7);
		adjlist1[1].add(edge4_4);
		
		adjlist1[2].add(edge1_6);
		adjlist1[2].add(edge4_9);
		
		adjlist1[3].add(edge2_1);
		adjlist1[3].add(edge3_3);
		
		System.out.println(chGraph.isReverseSame(adjlist1));
		
		// [Task 2]인접 행렬로 구현
		System.out.println("[Task 2]");
		int[][] adjmat2 = {{0, 2, 3, 0},
						   {7, 0, 0, 4},
						   {6, 0, 0, 9},
						   {0, 0, 3, 0}};
		
		System.out.println(chGraph.isReverseSame(adjmat2));
		
		// [Task 2]인접 리스트로 구현
		List<Edge>[] adjlist2 = new List[4];
		for (int i = 0; i < adjlist2.length; i++) {
			adjlist2[i] = new LinkedList<>(); 
		}
		
		adjlist2[0].add(edge2_2);
		adjlist2[0].add(edge3_3);
		
		adjlist2[1].add(edge1_7);
		adjlist2[1].add(edge4_4);
		
		adjlist2[2].add(edge1_6);
		adjlist2[2].add(edge4_9);
		
		adjlist2[3].add(edge3_3);
		
		System.out.println(chGraph.isReverseSame(adjlist2));
		
		// [Task 3]인접 행렬로 구현
		System.out.println("[Task 3]");
		int[][] adjmat3 = { { 0, 1, 4, 0 }, 
							{ 1, 0, 0, 2 }, 
							{ 4, 0, 0, 3 }, 
							{ 0, 2, 3, 0 } };

		System.out.println(chGraph.isReverseSame(adjmat3));
		
		// [Task 3]인접 리스트로 구현
		List<Edge>[] adjlist3 = new List[4];
		for (int i = 0; i < adjlist3.length; i++) {
			adjlist3[i] = new LinkedList<>(); 
		}
		
		Edge edgeTo1_1 = new Edge(1, 1);
		Edge edgeTo1_4 = new Edge(1, 4);
		
		Edge edgeTo2_1 = new Edge(2, 1);
		Edge edgeTo2_2 = new Edge(2, 2);
		
		Edge edgeTo3_3 = new Edge(3, 3);
		Edge edgeTo3_4 = new Edge(3, 4);
		
		Edge edgeTo4_2 = new Edge(4, 2);
		Edge edgeTo4_3 = new Edge(4, 3);
		
		adjlist3[0].add(edgeTo2_1);
		adjlist3[0].add(edgeTo3_4);
		
		adjlist3[1].add(edgeTo1_1);
		adjlist3[1].add(edgeTo4_2);
		
		adjlist3[2].add(edgeTo1_4);
		adjlist3[2].add(edgeTo4_3);
		
		adjlist3[3].add(edgeTo2_2);
		adjlist3[3].add(edgeTo3_3);
		
		System.out.println(chGraph.isReverseSame(adjlist3));
		
		// [Task 4]인접 행렬로 구현
		System.out.println("[Task 4]");
		int[][] adjmat4 = adjmat3; // 무방향 그래프는 양쪽방향으로 간선이 모두 존재하는 것과 같음 즉, 그래프3과 같음
		
		System.out.println(chGraph.isReverseSame(adjmat4));

		// [Task 4]인접 리스트로 구현
		List<Edge>[] adjlist4 = adjlist3;
		
		System.out.println(chGraph.isReverseSame(adjlist4));
	}
}
