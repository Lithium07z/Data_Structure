import java.util.LinkedList;
import java.util.List;

public class AdjListGraphExt extends AdjListGraph {
	private List<Edge>[] adjListReverse; // this.adjList�� �ش��ϴ� �׷����� ������ �׷����� ��������Ʈ ���·� �����ϴ� ��� ����
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
	
	public void getReverse() { // ��� ������ this.adjList �׷����� ������ �׷����� this.adjListReverse�� �����ϴ� �޼ҵ�
		this.adjListReverse = new List[adjList.length]; // adjListReverse�� �����⸸ �ѰŶ� adjList�� ũ�Ⱑ ���� 
		int[][] arr = new int[adjList.length][adjList.length]; // ���� ��� ����
		for (int i = 0; i < adjList.length; i++) {
			for (int j = 0; j < adjList[i].size(); j++) { // adjList�� �ε��� ���� ����� ����Ʈ�� ���� �� �ε��� ������ ����� �ٸ� �����̹Ƿ�
				int num = adjList[i].get(j).adjvertex; // ���� i�� ����� ����
				arr[i][num] = 1; // ���� i�� ������ �� num�� ��ġ�� 1�̹Ƿ� 1 �־��� 
			}
		}
		for (int i = 0; i < adjList.length; i++) {
			for (int j = i + 1; j < adjList.length; j++) { // j�� 0���� �����ϸ� ���� ��ġ�� �ٲ�ġ���� i + 1���� ���� 
				int temp = arr[i][j];
				arr[i][j] = arr[j][i]; // ������ �׷����� �׷��� �ϹǷ� ��� ���� ��ġ�� �ٲ�ġ��
				arr[j][i] = temp;
			}
		}
		for (int i = 0; i < adjList.length; i++) { // �ٽ� ����Ʈ�� ������ֱ� 
			adjListReverse[i] = new LinkedList<>();
			for (int j = 0; j < adjList.length; j++) {
				if (arr[i][j] == 1) { // 1�� �κ��� �� �� ������ ����� �κ��̴ϱ�
					Edge e = new Edge(j); // ���� i�� �������� j������ ������ ����
					adjListReverse[i].add(e); // ����Ʈ�� �߰� 
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
