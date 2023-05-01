package codingtest.test.level3;

import java.util.Arrays;

public class 정수_삼각형 {
    public static int[][] mem = new int[501][501];

    public static void main(String[] args) {
        int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int result = solution(triangle);
        System.out.println("result = " + result);
    }

    private static int solution(int[][] triangle) {
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        return dfs(triangle, 0, 0);
    }

    private static int dfs(int[][] triangle, int x, int y) {
        if (y == triangle.length) return 0;
        if (mem[y][x] != -1) return mem[y][x];

        return mem[y][x] = triangle[y][x] + Math.max(
                dfs(triangle, x, y + 1),
                dfs(triangle, x + 1, y + 1)
        );
    }
}
