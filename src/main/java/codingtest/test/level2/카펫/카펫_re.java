package codingtest.test.level2.카펫;

public class 카펫_re {
    class Solution {
        public int[] solution(int brown, int yellow) {
            return getArea(brown, yellow);
        }

        private int[] getArea(int brown, int yellow) {
            for (int x = 1; x * x <= yellow; x++) {
                if (yellow % x != 0) continue;
                int y = yellow / x;
                if ((x + 2) * (y + 2) - yellow == brown) return new int[]{y + 2, x + 2};
            }
            return new int[]{};
        }
    }
}
