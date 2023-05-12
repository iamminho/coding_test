package codingtest.test.level2.거리두기_확인하기;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 거리두기_확인하기_bfs {
    private class Sit {
        int x;
        int y;
        int dist;
        char state;
        List<int[]> visited = new ArrayList<>();

        public Sit(int x, int y, int dist, char state) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.state = state;
        }
    }

    private final int[] dx = new int[]{0, 1, 0, -1};
    private final int[] dy = new int[]{1, 0, -1, 0};


    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = inspect(places[i]);
        }

        return answer;
    }

    private int inspect(String[] place) {
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length(); j++) {
                if (place[i].charAt(j) == 'P') {
                    boolean result = search(place, j, i);
                    if (!result) return 0;
                }
            }
        }
        return 1;
    }

    private boolean search(String[] place, int x, int y) {
        Stack<Sit> stack = new Stack<>();
        stack.add(new Sit(x, y, 0, 'X'));


        while (!stack.isEmpty()) {
            Sit target = stack.pop();

            if (target.state == 'P') return false;

            if (target.dist >= 2) continue;

            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i] + target.x;
                int ny = dy[i] + target.y;

                if (nx >= 0 && nx < place[0].length() && ny >= 0 && ny < place.length && place[ny].charAt(nx) != 'X' && !isVisited(target, nx, ny)) {
                    Sit newSit = new Sit(nx, ny, target.dist + 1, place[ny].charAt(nx));
                    newSit.visited.add(new int[]{target.x, target.y});
                    stack.add(newSit);
                }
            }
        }

        return true;
    }

    private boolean isVisited(Sit sit, int x, int y) {
        List<int[]> visited = sit.visited;
        for (int i = 0; i < visited.size(); i++) {
            int[] values = visited.get(i);
            if (values[0] == x && values[1] == y) return true;
        }
        return false;
    }
}
