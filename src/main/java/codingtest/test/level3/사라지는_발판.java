package codingtest.test.level3;

public class 사라지는_발판 {
    private static class Coord {
        public final int x;
        public final int y;

        private Coord(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    private static class Result {
        public final boolean win;
        public final int turns;

        public Result(boolean win, int turns) {
            this.win = win;
            this.turns = turns;
        }
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return game(new Coord(aloc[1], aloc[0]), new Coord(bloc[1], aloc[0]), board).turns;
    }

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private Result game(Coord player, Coord opponent, int[][] board) {

        // 종료조건
        if (board[player.y][player.x] == 0) {
            return new Result(false, 0);
        }

        boolean win = false;
        int winTurns = Integer.MAX_VALUE;
        int loseTurns = Integer.MIN_VALUE;

        board[player.y][player.x] = 0;
        for (int d = 0; d < 4; d++) {
            int nx = player.x + dx[d];
            int ny = player.y + dy[d];

            if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[ny].length) continue;
            if (board[ny][nx] == 0) continue;

            Result result = game(opponent, new Coord(nx, ny), board);

            // result의 win이 false면 상대방이 진거
            // 결국 나는 이긴거
            // 내가이기면 최소의 움직임
            if (!result.win) {
                win = true;
                winTurns = Math.min(winTurns, result.turns);
                // result의 win이 true면 내가 진거
                // 결국 상대방이 이긴거
                // 상대방이 이기면 최대의 움직임
            } else if (!win) {
                loseTurns = Math.max(loseTurns, result.turns);
            }
        }
        board[player.y][player.x] = 1;

        // win이 true이면 한번이라도 이긴적이 있는것
        // 그러니 result의 true를 담아 반환해준다.
        // 가장 적은 횟수의 winTurns에 다음 턴으로 넘기는 횟수인 1을 더해 반환한다.
        if (win) {
            return new Result(true, winTurns + 1);
        }

        // loseTurns가 그대로 MIN_VALUE이면 움직이지 못했다는 소리
        // 움직이지 못했으니 0을 반환해준다.
        if (loseTurns == Integer.MIN_VALUE) {
            return new Result(false, 0);
        }

        // win이 false이면 결국 졌다는 소리
        // loseTurns에 다음 턴으로 넘기는 횟수인 1을 더해 반환한다.
        return new Result(false, loseTurns + 1);
    }
}
