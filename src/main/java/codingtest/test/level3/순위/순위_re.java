package codingtest.test.level3.순위;

public class 순위_re {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
        };

        int answer = solution(n, results);
        System.out.println("answer = " + answer);

    }

    private static int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n][n];
        for (int[] edge : results) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u][v] = true;
        }
        return 0;
    }

    private int countForward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph[u].length; v++) {
            if (!graph[u][v] || isVisited[v]) continue;
            isVisited[v] = true;
            count += countForward(v, graph, isVisited);
        }
        

        return count;
    }
}
