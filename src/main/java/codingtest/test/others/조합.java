package codingtest.test.others;

public class 조합 {
    public static void main(String[] args) {
        String[] ele = {"A", "B", "C"};
        combination(0, ele, new boolean[ele.length], 0, 2);
    }

    private static void combination(int level, String[] ele, boolean[] visited, int start, int r) {
        if (level == r) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) builder.append(ele[i]);
            }
            System.out.println(builder.toString());
            return;
        }
        for (int i = start; i < ele.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(level + 1, ele, visited, i + 1, 2);
                visited[i] = false;
            }
        }
    }
}
