package codingtest.test.level2.체육대회;

public class 메모이제이션_프로세스 {
    public static void main(String[] args) {
        int[][] ability = new int[][]{
                {40, 10, 10},
                {20, 5, 0},
                {30, 30, 30},
                {70, 0, 70},
                {100, 100, 100}
        };

        solution(ability);
    }

    private static int result = 0;

    public static int solution(int[][] ability) {
        getMaxScore(0, 0, ability, new boolean[ability.length]);
        return result;
    }

    private static void getMaxScore(int score, int event, int[][] ability, boolean[] visited) {
        System.out.println("student = " + event);
        printVisited(visited);
        System.out.println("-----------------");
        if (event == ability[0].length) {
            result = Math.max(score, result);
            return;
        }

        for (int i = 0; i < ability.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                getMaxScore(score + ability[i][event], event + 1, ability, visited);
                visited[i] = false;
            }
        }
    }

    private static void printVisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) System.out.print(i + 1 + " ");
        }
        System.out.println("");
    }

}
