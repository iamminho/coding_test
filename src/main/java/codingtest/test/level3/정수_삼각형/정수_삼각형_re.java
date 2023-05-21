package codingtest.test.level3.정수_삼각형;

import java.util.Arrays;

public class 정수_삼각형_re {
    class Solution {
        private int[][] mem;

        public int solution(int[][] triangle) {
            mem = new int[501][501];

            for (int i = 0; i < mem.length; i++) {
                Arrays.fill(mem[i], -1);
            }

            getMax(0, 0, triangle);

            return mem[0][0];
        }

        private int getMax(int x, int y, int[][] triangle) {
            if (y == triangle.length) {
                return 0;
            }

            if (mem[x][y] != -1) return mem[x][y];

            return mem[x][y] = triangle[y][x] + Math.max(
                    getMax(x, y + 1, triangle),
                    getMax(x + 1, y + 1, triangle));
        }
    }
}
