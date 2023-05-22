package codingtest.test.level3.등굣길;

import java.util.Arrays;

public class 등굣길 {
    private static int[][] mem = new int[101][101];


    public static void main(String[] args) {
        int n = 6;
        int m = 7;
        int[][] puddles = new int[][]{{2, 2}, {3, 4}, {4, 3}};
        int total = solution(n, m, puddles);
        System.out.println("total = " + total);
    }

    private static int solution(int n, int m, int[][] puddles) {
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] puddle : puddles) {
            isPuddle[puddle[0]][puddle[1]] = true;
        }

        return move(1, 1, m, n, isPuddle);
    }

    private static int move(int x, int y, int m, int n, boolean[][] isPuddle) {
        if (y > n || x > m) return 0;
        if (isPuddle[y][x]) return 0;

        if (mem[y][x] != -1) return mem[y][x];
        if (y == n && x == m) return 1;

        int total = move(x + 1, y, m, n, isPuddle) + move(x, y + 1, m, n, isPuddle);
        return mem[y][x] = total % 1000000007;
    }
}
