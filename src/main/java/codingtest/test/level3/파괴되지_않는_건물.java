package codingtest.test.level3;

public class 파괴되지_않는_건물 {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}
        };

        int[][] skills = new int[][]{
                {1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}
        };

        solution(board, skills);
    }

    private static void solution(int[][] board, int[][] skills) {
        int[][] changes = new int[board.length + 1][board[0].length + 1];

        for (int[] skill : skills) {
            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3] + 1;
            int c2 = skill[4] + 1;
            int degree = skill[5];
            if (type == 1) degree = -degree;

            changes[r1][c1] += degree;
            changes[r2][c1] -= degree;
            changes[r1][c2] -= degree;
            changes[r2][c2] += degree;
        }

        //printArray(board);

        for (int y = 0; y < changes.length; y++) {
            for (int x = 0; x < changes[y].length; x++) {
                int left = x > 0 ? changes[y][x - 1] : 0;
                int up = y > 0 ? changes[y - 1][x] : 0;
                int diag = x > 0 && y > 0 ? changes[y - 1][x - 1] : 0;
                changes[y][x] += left + up - diag;
            }
        }

        for (int i = 0; i < changes.length; i++) {
            for (int j = 0; j < changes[0].length; j++) {
                System.out.print(changes[i][j] + " ");
            }
            System.out.println();
        }

        int safe = 0;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                board[y][x] += changes[y][x];
            }
        }

        //printArray(board);
    }

    private static void printArray(int[][] array) {
        System.out.println("------------------");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
