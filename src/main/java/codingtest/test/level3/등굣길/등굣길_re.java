package codingtest.test.level3.등굣길;

import java.util.Arrays;

public class 등굣길_re {
    class Solution {
        int[][] puddleMap;
        int[][] mem = new int[101][101];

        public int solution(int m, int n, int[][] puddles) {
            puddleMap = new int[n + 1][m + 1];
            for (int[] puddle : puddles) {
                puddleMap[puddle[1]][puddle[0]] = -1;
            }

            for (int[] row : mem) {
                Arrays.fill(row, -1);
            }

            int result = toSchool(1, 1, m, n);
            return result;
        }

        private int toSchool(int x, int y, int m, int n) {
            if (x > m || y > n) return 0;
            if (x == m && y == n) return 1;

            if (puddleMap[y][x] == -1) return 0;
            if (mem[x][y] != -1) return mem[x][y];

            int total = mem[x][y] = toSchool(x + 1, y, m, n) + toSchool(x, y + 1, m, n);
            return mem[x][y] = total % 1000000007;
        }
    }
}
