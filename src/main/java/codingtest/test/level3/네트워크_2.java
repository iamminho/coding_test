package codingtest.test.level3;

import java.util.Stack;

public class 네트워크_2 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 1, 1}
        };

        int answer = solution(n, computers);
        System.out.println("answer = " + answer);
    }

    private static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[computers.length];
        int count = 0;

        for (int next = 0; next < computers.length; next++) {
            if (!visited[next]) {
                visitAll(next, computers, visited);
                count++;
            }
        }

        return count;
    }

    private static void visitAll(int index, int[][] computers, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(index);

        while (!stack.isEmpty()) {
            int c = stack.pop();
            if (visited[c]) continue;
            visited[c] = true;

            int[] computer = computers[c];
            for (int i = 0; i < computer.length; i++) {
                if (computer[i] == 0) continue;
                stack.push(i);
            }
        }
    }
}
