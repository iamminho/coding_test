package codingtest.test.level3.순위;

public class 순위 {
    // 해당 번호로 올 수 있는 갯수 + 해당 번호에서 갈 수 있는 갯수 == n 이면 순위를 매길 수 있다.

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

        int count = 0;
        for (int u = 0; u < n; u++) {
            int wins = countForward(u, graph, new boolean[n]) - 1;
            int loses = countBackward(u, graph, new boolean[n]) - 1;
            if (wins + loses + 1 == n) count++;
        }

        return count;
    }

    private static int countForward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph[u].length; v++) {
            if (!graph[u][v] || isVisited[v]) continue;
            isVisited[v] = true;
            count += countForward(v, graph, isVisited);
        }


        return count;
    }

    private static int countBackward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph.length; v++) {
            if (!graph[v][u] || isVisited[v]) continue;
            isVisited[v] = true;
            count += countBackward(v, graph, isVisited);
        }


        return count;
    }

}
