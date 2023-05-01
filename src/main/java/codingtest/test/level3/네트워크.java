package codingtest.test.level3;

public class 네트워크 {
    private static boolean[] visited;

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 1, 1}
        };

        int answer = solution(n, computers);
        System.out.println(answer);
    }

    private static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int idx = 0; idx < computers.length; idx++) {
            if (!visited[idx]) {
                dfs(idx, computers);
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int index, int[][] computers) {
        visited[index] = true;
        int[] computer = computers[index];
        for (int i = 0; i < computer.length; i++) {
            if (!visited[i] && computer[i] == 1) {
                dfs(i, computers);
            }
        }
    }
}
