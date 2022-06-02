import java.util.LinkedList;
import java.util.List;

public class CheckGraph {
	public static boolean isReverseSame(int[][] G) { // G와 GR이 동일하면 true, 그렇지 않으면 false를 리턴
		int[][] Arr = G;
		int[][] reArr = new int[G.length][G.length];

		for (int i = 0; i < G.length; i++) {
			for (int j = 0; j < G.length; j++) {
				reArr[i][j] = G[i][j]; // 뒤집은 그래프를 저장할 배열에 먼저 원래 배열 G를 넣어줌
			}
		}

		for (int i = 0; i < reArr.length; i++) { // reArr은 뒤집은 그래프여야 하므로 행과 열을 바꿔줌
			for (int j = i + 1; j < reArr.length; j++) {
				int temp = reArr[i][j];
				reArr[i][j] = reArr[j][i];
				reArr[j][i] = temp;
			}
		}

		for (int i = 0; i < reArr.length; i++) {
			for (int j = 0; j < reArr.length; j++) {
				if (Arr[i][j] != reArr[i][j]) { // 원래 그래프와 뒤집은 그래프 중 일치하지 않는 부분이 있다면 서로 다른 것이므로 false 반환
					return false;
				}
			}
		}
		return true; // 반복문 중간에 false에 걸리지 않았다면 모두 일치하는 것이므로 true 반환
	}

	public static boolean isReverseSame(List<Edge>[] G) {// G와 GR이 동일하면 true, 그렇지 않으면 false를 리턴. 인자는 G만 주어짐
		List<Edge>[] List = G;
		List<Edge>[] reverseList = new List[G.length];
		int[][] reArr = new int[List.length][List.length];
		for (int i = 0; i < List.length; i++) { // 배열에 인접리스트 값을 모두 넣음
			for (int j = 0; j < List[i].size(); j++) {
				reArr[i][List[i].get(j).adjvertex - 1] = List[i].get(j).weight;
			}
		}
		for (int i = 0; i < reArr.length; i++) { // 행과 열을 바꿔서 뒤집고
			for (int j = i + 1; j < reArr.length; j++) {
				int temp = reArr[i][j];
				reArr[i][j] = reArr[j][i];
				reArr[j][i] = temp;
			}
		}
		return isReverseSame(reArr);
	}
}