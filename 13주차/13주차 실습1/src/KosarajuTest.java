import java.util.LinkedList;
import java.util.List;

public class KosarajuTest {
	public static void main(String[] args) {
		List<Edge>[] adjList;
		// 인접 행렬 구현
		int[][] arr = { { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
						{ 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
						{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
						{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 1, 1, 0, 1 },
						{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } };
		adjList = new List[10];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<>();
			for (int j = 0; j < adjList.length; j++) {
				if (arr[i][j] == 1) {
					Edge e = new Edge(j);
					adjList[i].add(e);
				}
			}
		}
		Kosaraju kosj = new Kosaraju(adjList);
		kosj.reverseDFS();
		
	}
}
