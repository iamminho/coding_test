package codingtest.test.level0;

import java.util.HashSet;
import java.util.Set;

public class 평행 {
    /*
     * 평행의 조건이 무엇인가?
     * 기울기가 같아야 한다.
     * 기울기는 어떻게 구하는가?
     * y2 - y1 / x2 - x1
     *
     *
     * */
    private static int[][] condition = new int[][]{
            {0, 1},
            {0, 2},
            {0, 3},
            {1, 2},
            {1, 3},
            {2, 3}
    };

    public static void main(String[] args) {
        int[][] dots = new int[][]{
                {3, 5},
                {4, 1},
                {2, 4},
                {5, 10}
        };

        int result = solution(dots);
        System.out.println("result = " + result);

    }

    private static int solution(int[][] dots) {
        Set<Double> slopes = new HashSet<>();

        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                double slope = getSlope(dots[i][0], dots[i][1], dots[j][0], dots[j][1]);
                if (slopes.contains(slope)) return 1;
                slopes.add(slope);
            }
        }

        return 0;
    }

    private static double getSlope(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }
}
