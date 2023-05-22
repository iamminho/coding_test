package codingtest.test.level4.사칙연산;

import java.util.Arrays;

public class 사칙연산 {
    private static final int[][] maxMem = new int[202][202];
    private static final int[][] minMem = new int[202][202];

    public static void main(String[] args) {
        String[] arr = new String[]{"1", "-", "3", "+", "5", "-", "8"};
        int result = solution(arr);
        System.out.println("result = " + result);
    }

    private static int solution(String[] arr) {
        for (int[] row : maxMem) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        for (int[] row : minMem) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return max(0, arr.length, arr);
    }

    private static int max(int start, int end, String[] arr) {
        //종료조건
        if (end - start == 1) return Integer.parseInt(arr[start]);
        if (maxMem[start][end] != Integer.MIN_VALUE) {
            return maxMem[start][end];
        }

        int max = Integer.MIN_VALUE;
        for (int i = start + 1; i < end; i += 2) {
            int l = max(start, i, arr);
            int v;
            if (arr[i].equals("+")) {
                int r = max(i + 1, end, arr);
                v = l + r;
            } else {
                int r = min(i + 1, end, arr);
                v = l - r;
            }
            if (v > max) max = v;
        }
        return maxMem[start][end] = max;
    }

    private static int min(int start, int end, String[] arr) {
        if (end - start == 1) return Integer.parseInt(arr[start]);
        if (minMem[start][end] != Integer.MIN_VALUE) {
            return minMem[start][end];
        }

        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i += 2) {
            int l = min(start, i, arr);
            int v;
            if (arr[i].equals("+")) {
                int r = min(i + 1, end, arr);
                v = l + r;
            } else {
                int r = max(i + 1, end, arr);
                v = l - r;
            }
            if (v < min) min = v;
        }
        return minMem[start][end] = min;
    }
}
