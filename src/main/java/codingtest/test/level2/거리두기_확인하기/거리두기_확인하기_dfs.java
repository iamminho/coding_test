package codingtest.test.level2.거리두기_확인하기;

import java.util.ArrayList;
import java.util.List;

public class 거리두기_확인하기_dfs {
    private static final int[] dx = new int[]{1, 0, -1, 0};
    private static final int[] dy = new int[]{0, 1, 0, -1};
    private static boolean flag;

    public static List<Integer> solution(String[][] places) {
        List<Integer> result = new ArrayList<>();

        for (String[] place : places) {
            flag = true;
            result.add((isKeepDist(place)) ? 1 : 0);
        }

        return result;
    }

    private static boolean isKeepDist(String[] place) {
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[0].length(); j++) {
                if (place[i].charAt(j) == 'P') {
                    boolean[][] visited = new boolean[place.length][place[0].length()];
                    visited[i][j] = true;
                    search(place, j, i, 0, visited);
                    if (!flag) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void search(String[] place, int x, int y, int deep, boolean[][] visited) {
        if (deep == 2) {
            if (place[y].charAt(x) == 'P') {
                flag = false;
                return;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < place[0].length() && ny >= 0 && ny < place.length && place[ny].charAt(nx) != 'X' && !visited[ny][nx]) {
                if (place[ny].charAt(nx) == 'P') {
                    flag = false;
                    return;
                }
                visited[ny][nx] = true;
                search(place, nx, ny, deep + 1, visited);
                visited[ny][nx] = false;
            }
        }
    }
}
