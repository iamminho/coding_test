package codingtest.test.level2;

import java.util.LinkedList;
import java.util.List;

public class 삼각_달팽이 {
    public static void main(String[] args) {
        int[][] board = solution(5);
        List<Integer> result = mapping(board);
        System.out.println(result);
    }

    public static int[][] solution(int n) {
        int[][] board = new int[n][n];
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};
        int x = 0;
        int y = 0;
        int number = 1;
        int cur = 0;

        while (true) {
            if (board[y][x] > 0) break;
            board[y][x] = number++;

            int Dx = x + dx[cur];
            int Dy = y + dy[cur];

            if (Dy == n || Dx == n || Dy == -1 || Dx == -1 || board[Dy][Dx] != 0) {
                cur = (cur + 1) % 3;
                Dx = x + dx[cur];
                Dy = y + dy[cur];
                if (Dy == n || Dx == n || Dy == -1 || Dx == -1 || board[Dy][Dx] != 0) break;
            }

            x = Dx;
            y = Dy;
        }
        return board;
    }

    private static List<Integer> mapping(int[][] board) {
        List<Integer> result = new LinkedList<>();
        for (int[] numbers : board) {
            for (int number : numbers) {
                if (number > 0) result.add(number);
            }
        }
        return result;
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
