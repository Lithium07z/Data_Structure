public class FindPath {
	static int goY, goX;
	static int value;
	public static void main(String[] args) {
		int[][] map1 = {{  0,100,  0},
						{100, 10,  0},
						{ 10,  0,  0}};
		int[][] map2 = {{  0,1000,  0},
					    {100,  10,  0},
					    { 10,   0,  0}};
		reset(map1);
		if (findPath(map1) == 1) {
			System.out.println("map1 : Found a path!");
		} else {
			System.out.println("map1 : There is no path!");
		}
		reset(map2);
		if (findPath(map2) == 1) {
			System.out.println("map2 : Found a path!");
		} else {
			System.out.println("map2 : There is no path!");
		}
	}
	
	public static int findPath(int[][] map) {
		if (value == 0) {
			if (goY == 0 && goX == 2) {
				return 1;
			} else {
				return 0;
			}
		} else if (value == 1000) {
			value = map[goY][goX-1];
			goX -= 1;
		} else if (value == 100) {
			value = map[goY][goX+1];
			goX +=1;
		} else if (value == 10) {
			value = map[goY-1][goX];
			goY -= 1;
		} else if (value == 1) {
			value = map[goY+1][goX];
			goY +=1;
		}
		return findPath(map);
	}
	
	public static void reset(int[][] map) {
		value = map[2][0];
		goY = 2; goX = 0;
	}
}
