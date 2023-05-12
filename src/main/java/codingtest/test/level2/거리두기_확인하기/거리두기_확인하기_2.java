package codingtest.test.level2.거리두기_확인하기;

import java.util.Arrays;

public class 거리두기_확인하기_2 {
    private static final int dx[] = {0, -1, 1, 0};
    private static final int dy[] = {-1, 0, 0, 1};

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] result = solution(places);
        Arrays.stream(result)
                .forEach(System.out::print);
    }

    private static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            if (isDistanced(room)) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }

    private static boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }

    private static boolean isDistanced(char[][] room, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;

            switch (room[ny][nx]) {
                case 'P':
                    return false;
                case 'O':
                    if (isNextToPeople(room, nx, ny, 3 - d)) return false;
                    break;
            }
        }
        return true;
    }

    private static boolean isNextToPeople(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) continue;

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }

//    private static void printRoom(char[][] room) {
//        for (int i = 0; i < room.length; i++) {
//            for (int j = 0; j < room[0].length; j++) {
//                System.out.print(room[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("--------------");
//    }
}
