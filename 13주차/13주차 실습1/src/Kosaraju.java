import java.util.LinkedList;
import java.util.List;

public class Kosaraju extends AdjListGraphExt {
	private List<Edge>[] adjListReverse; // this.adjList�� �ش��ϴ� �׷����� ������ �׷����� ��������Ʈ ���·� �����ϴ� ��� ����
	private List<Edge>[] adjList;
	private List<Integer> topological;
	
	public Kosaraju(List<Edge>[] adjList) {
		super.setAdjList(adjList); // AdjListGraphExt�� adjList�� �����ڷ� ���� adjList�� �ʱ�ȭ ���� 
		super.getReverse(); // �����ڷ� ���� adjList�� �Ųٷ� ������ 
		this.adjList = adjList; // �����ڷ� ���� adjList�� KosarajuŬ������ adjList �ʱ�ȭ
		this.adjListReverse = super.getAdjListReverse(); // �����ڷ� ���� adjList�� ������ AdjListReveres�� AdjListGraphExt���� ����
	}

	public void reverseDFS() {
		List<Integer>[] adjListInt = new List[adjList.length]; // ���������� Integer ����Ʈ�� ListŸ������ �ٲ���
		for (int i = 0; i < adjListReverse.length; i++) {
			adjListInt[i] = new LinkedList<Integer>();
			for (int j = 0; j < adjList[i].size(); j++) {
				adjListInt[i].add(adjList[i].get(j).adjvertex); // Edge�� adjvertex�� �� Edge�� ������ ����Ʈ�� �߰� 
			}
		}
		TopologicalSort tpgSort = new TopologicalSort(adjListInt); // IntegerŸ������ �ٲ� ����Ʈ�� TopologicalSortŬ������ ���� 
		topological = tpgSort.tsort(); // �������ĵ� ����� Kosaraju Ŭ������ topological ����Ʈ�� ����
		KosarajuDFS kDFS = new KosarajuDFS(adjListReverse, topological); // �������� ����Ʈ�� �������� ����� kDFS�� ���� 
	}
}
