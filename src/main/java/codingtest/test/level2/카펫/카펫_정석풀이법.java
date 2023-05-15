package codingtest.test.level2.카펫;

public class 카펫_정석풀이법 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            return getArea(brown, yellow);
        }

        private int[] getArea(int brown, int yellow) {
            for (int width = 3; width <= 5000; width++) {
                for (int height = 3; height <= width; height++) {
                    int boundary = (width + (height - 2)) * 2;
                    int center = width * height - boundary;
                    if (boundary == brown && center == yellow) return new int[]{width, height};
                }
            }
            return new int[]{};
        }
    }
}
