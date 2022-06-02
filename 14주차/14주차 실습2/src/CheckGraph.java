import java.util.LinkedList;
import java.util.List;

public class CheckGraph {
	public static boolean isReverseSame(int[][] G) { // G�� GR�� �����ϸ� true, �׷��� ������ false�� ����
		int[][] Arr = G;
		int[][] reArr = new int[G.length][G.length];

		for (int i = 0; i < G.length; i++) {
			for (int j = 0; j < G.length; j++) {
				reArr[i][j] = G[i][j]; // ������ �׷����� ������ �迭�� ���� ���� �迭 G�� �־���
			}
		}

		for (int i = 0; i < reArr.length; i++) { // reArr�� ������ �׷������� �ϹǷ� ��� ���� �ٲ���
			for (int j = i + 1; j < reArr.length; j++) {
				int temp = reArr[i][j];
				reArr[i][j] = reArr[j][i];
				reArr[j][i] = temp;
			}
		}

		for (int i = 0; i < reArr.length; i++) {
			for (int j = 0; j < reArr.length; j++) {
				if (Arr[i][j] != reArr[i][j]) { // ���� �׷����� ������ �׷��� �� ��ġ���� �ʴ� �κ��� �ִٸ� ���� �ٸ� ���̹Ƿ� false ��ȯ
					return false;
				}
			}
		}
		return true; // �ݺ��� �߰��� false�� �ɸ��� �ʾҴٸ� ��� ��ġ�ϴ� ���̹Ƿ� true ��ȯ
	}

	public static boolean isReverseSame(List<Edge>[] G) {// G�� GR�� �����ϸ� true, �׷��� ������ false�� ����. ���ڴ� G�� �־���
		List<Edge>[] List = G;
		List<Edge>[] reverseList = new List[G.length];
		int[][] reArr = new int[List.length][List.length];
		for (int i = 0; i < List.length; i++) { // �迭�� ��������Ʈ ���� ��� ����
			for (int j = 0; j < List[i].size(); j++) {
				reArr[i][List[i].get(j).adjvertex - 1] = List[i].get(j).weight;
			}
		}
		for (int i = 0; i < reArr.length; i++) { // ��� ���� �ٲ㼭 ������
			for (int j = i + 1; j < reArr.length; j++) {
				int temp = reArr[i][j];
				reArr[i][j] = reArr[j][i];
				reArr[j][i] = temp;
			}
		}
		return isReverseSame(reArr);
	}
}