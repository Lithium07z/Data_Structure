/* 프로그램 최종 수정일자 : 2022.03.23 15:03
 * 프로그램 작성자 : 20195138 김준호
 * 프로그램 설명 : 다항식 출력 및 두 다항식의 합 출
 */
public class ArrListPolyTest {
	public static void main(String[] args) {
		ArrListPoly p1 = new ArrListPoly();
		int poly1[] = {9, 0, -3, 0, 5}; // 9 x0 + 0 x1 + -3 x2 + 0 x3 + 5 x4
		int p1highestDegree = poly1.length - 1;
		p1.setPoly(p1highestDegree, poly1);
		printPolyEq(p1, 1); // 다항식 출력전에 출력할 탭 수  = 1
		
		ArrListPoly p2 = new ArrListPoly();
		int poly2[] = {2, 0, 4}; // 2 x0 + 0 x1 + 4 x2
		int p2highestDegree = poly2.length - 1;
		p2.setPoly(p2highestDegree, poly2);
		printPolyEq(p2, 3); // 다항식 출력전에 출력할 탭 수  = 3
		
		ArrListPoly p3 = p1.sumPoly(p2);
		printPolyEq(p3, 1); // 다항식 출력전에 출력할 탭 수  = 1
	}
	public static void printPolyEq(ArrListPoly p, int nTabs) {
		for (int i = 0; i < nTabs; i++) {
			System.out.print("\t");
		}
		for (int i = p.getHighestDegree(); i >= 0; i--) {
			System.out.printf("%+d x%d\t", p.peek(i), i);
		}
		System.out.println();
	}
}
