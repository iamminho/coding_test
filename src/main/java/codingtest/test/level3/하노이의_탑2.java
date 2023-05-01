package codingtest.test.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이의_탑2 {
    public static void main(String[] args) {
        int n = 3;

    }

    private static List<List<Integer>> solution(int n) {
        List<List<Integer>> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process;
    }

    private static void hanoi(int n, int from, int to, List<List<Integer>> process) {
        if (n == 1) {
            process.add(new ArrayList<>(Arrays.asList(from, to)));
            return;
        }

        int empty = 6 - from - to;

        hanoi(n - 1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n - 1, empty, to, process);
    }
}
