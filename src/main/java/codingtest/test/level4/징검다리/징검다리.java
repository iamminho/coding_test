package codingtest.test.level4.징검다리;

import java.util.Arrays;

public class 징검다리 {
    public static void main(String[] args) {
        int[] rocks = new int[]{2, 14, 11, 21, 17};
        int distance = 25;
        int n = 2;
        int result = solution(distance, rocks, n);
        System.out.println("result = " + result);
    }

    private static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int[] copyRocks = Arrays.copyOf(rocks, rocks.length + 1);
        copyRocks[copyRocks.length - 1] = distance;

        return binarySearch(copyRocks, n);
    }

    private static int binarySearch(int[] rocks, int n) {
        int start = 1;
        int end = 1000000000;

        while (end - start > 1) {
            int d = (end + start) / 2;

            if (isValid(rocks, n, d)) start = d;
            else end = d;
        }
        return start;
    }

    private static boolean isValid(int[] rocks, int n, int d) {
        int last = 0;
        int removed = 0;

        for (int rock : rocks) {
            if (rock - last < d) {
                removed++;
                continue;
            }
            last = rock;

        }
        return removed <= n;
    }
}
