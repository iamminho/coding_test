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
            int Dx = x + dx[i];
            int Dy = y + dy[i];

            if (Dx >= 0 && Dy >= 0 && Dx < 5 && Dy < 5 && (place[Dy].charAt(Dx) == 'O' || place[Dy].charAt(Dx) == 'P')) {
                if (place[Dy].charAt(Dx) == 'P') return false;
                int count = 0;
                for (int j = 0; j < 4; j++) {
                    int DX = Dx + dx[j];
                    int DY = Dy + dy[j];
                    if (DX >= 0 && DY >= 0 && DX < 5 && DY < 5 && place[DY].charAt(DX) == 'P') count++;
                }
                if (count >= 2) return false;
            }
        }
        return true;
    }
}
