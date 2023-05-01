package codingtest.test.level3;

import java.util.ArrayList;
import java.util.List;

public class 하노이의_탑 {
    public static void main(String[] args) {
        int[][] result = solution(3);
        for (int[] ints : result) {

            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int n) {
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }

    private static void hanoi(int n, int from, int to, List<int[]> process) {
        if (n == 1) {
            process.add(new int[]{from, to});
            return;
        }

        int empty = 6 - from - to;

        hanoi(n - 1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n - 1, empty, to, process);
    }
}
