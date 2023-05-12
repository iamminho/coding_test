package codingtest.test.level2.거리두기_확인하기;

import java.util.LinkedList;
import java.util.List;

public class 거리두기_확인하기 {
    public static void main(String[] args) {
        List<Integer> result = new LinkedList<>();
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        for (String[] place : places) {
            if (solution(place)) result.add(1);
            else result.add(0);
        }
        System.out.println(result);
    }

    public static boolean solution(String[] place) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (place[y].charAt(x) == 'P' && !isManhattan(place, x, y)) return false;
            }
        }
        return true;
    }

    private static boolean isManhattan(String[] place, int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && (place[ny].charAt(nx) == 'O' || place[ny].charAt(nx) == 'P')) {
                if (place[ny].charAt(nx) == 'P') return false;
                int count = 0;
                for (int j = 0; j < 4; j++) {
                    int nnx = nx + dx[j];
                    int nny = ny + dy[j];
                    if (nnx >= 0 && nny >= 0 && nnx < 5 && nny < 5 && place[nny].charAt(nnx) == 'P') return false;
                }
                if (count >= 2) return false;
                // P로부터 출발했으므로 count가 두개일때 false조건이 성립한다.
            }
        }
        return true;
    }
}
