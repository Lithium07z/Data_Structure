import java.util.LinkedList;
import java.util.List;

public class PrimMSTTest {
	public static void main(String[] args) {
		List<Edge>[] list = new List[7];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<>();
		}
		
		Edge edgeTo0_9 = new Edge(0, 9);
		Edge edgeTo0_10 = new Edge(0, 10);
		
		Edge edgeTo1_3 = new Edge(1, 3);
		Edge edgeTo1_5 = new Edge(1, 5);
		Edge edgeTo1_9 = new Edge(1, 9);
		Edge edgeTo1_10 = new Edge(1, 10);
		
		Edge edgeTo2_2 = new Edge(2, 2);
		Edge edgeTo2_7 = new Edge(2, 7);
		Edge edgeTo2_9 = new Edge(2, 9);
		Edge edgeTo2_10 = new Edge(2, 10);
		
		Edge edgeTo3_4 = new Edge(3, 4);
		Edge edgeTo3_8 = new Edge(3, 8);
		Edge edgeTo3_9 = new Edge(3, 9);
		Edge edgeTo3_10 = new Edge(3, 10);
		
		Edge edgeTo4_1 = new Edge(4, 1);
		Edge edgeTo4_5 = new Edge(4, 5);
		Edge edgeTo4_7 = new Edge(4, 7);
		
		Edge edgeTo5_2 = new Edge(5, 2);
		Edge edgeTo5_4 = new Edge(5, 4);
		Edge edgeTo5_6 = new Edge(5, 6);
		
		Edge edgeTo6_1 = new Edge(6, 1);
		Edge edgeTo6_3 = new Edge(6, 3);
		Edge edgeTo6_6 = new Edge(6, 6);
		Edge edgeTo6_8 = new Edge(6, 8);
		
		list[0].add(edgeTo1_9);
		list[0].add(edgeTo2_10);
		
		list[1].add(edgeTo0_9);
		list[1].add(edgeTo3_10);
		list[1].add(edgeTo4_5);
		list[1].add(edgeTo6_3);
		
		list[2].add(edgeTo0_10);
		list[2].add(edgeTo3_9);
		list[2].add(edgeTo4_7);
		list[2].add(edgeTo5_2);
		
		list[3].add(edgeTo1_10);
		list[3].add(edgeTo2_9);
		list[3].add(edgeTo5_4);
		list[3].add(edgeTo6_8);
		
		list[4].add(edgeTo1_5);
		list[4].add(edgeTo2_7);
		list[4].add(edgeTo6_1);
		
		list[5].add(edgeTo2_2);
		list[5].add(edgeTo3_4);
		list[5].add(edgeTo6_6);
		
		list[6].add(edgeTo1_3);
		list[6].add(edgeTo3_8);
		list[6].add(edgeTo4_1);
		list[6].add(edgeTo5_6);
		
		PrimMST pMST = new PrimMST(list);
		int start = 0; // 시작 정점 
		pMST.mst(start);
	}
}
