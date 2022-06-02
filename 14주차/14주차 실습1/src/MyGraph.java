import java.util.LinkedList;
import java.util.List;

public class MyGraph {
	public static int[][] getAdjMatrixFromAdjList(List<Edge>[] lst) { // ��������Ʈ�� ǥ���� �׷����� ������ķ� ��ȯ�Ͽ� ����
		int[][] arr = new int[lst.length][lst.length];
		for (int i = 0; i < lst.length; i++) {
			for (int j = 0; j < lst[i].size(); j++) {
				arr[i][lst[i].get(j).adjvertex] = lst[i].get(j).weight;
			}
		}
		return arr;
	}

	public static List<Edge>[] getAdjListFromAdjMatrix(int[][] mat) { // ������ķ� ǥ���� �׷����� ��������Ʈ�� ǥ���� �׷����� ��ȯ�Ͽ� ����
		List<Edge>[] adjList = new List[mat.length];
		for (int i = 0; i < mat.length; i++) {
			adjList[i] = new LinkedList<>();
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j] != 0) {
					Edge e = new Edge(j, mat[i][j]);
					adjList[i].add(e);
				}
			}
		}
		return adjList;
	}

	public static void print(int[][] mat) { // ��������� �͹̳ο� ���
		System.out.println("AdjMatrix : ");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j]);
				if (j < mat.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}

	public static void print(List<Edge>[] lst) { // ��������Ʈ�� �͹̳ο� ���
		System.out.println("AdjList : ");
		for (int i = 0; i < lst.length; i++) {
			System.out.print("[" + i + "]");
			for (int j = 0; j < lst[i].size(); j++) {
				if (j < lst[i].size()) {
					System.out.print(" => ");
				}
				System.out.print(lst[i].get(j).adjvertex + "(" + lst[i].get(j).weight + ")");
			}
			System.out.println();
		}
	}
}