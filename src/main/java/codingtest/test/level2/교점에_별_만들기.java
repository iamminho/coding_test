package codingtest.test.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 교점에_별_만들기 {
    public static void main(String[] args) {
        int[][] line = {
//                {2, -1, 4},
//                {-2, -1, 4},
//                {0, -1, 1},
//                {5, -8, -12},
//                {5, 8, 12}
//                "------------"
//                {0, 1, -1},
//                {1, 0, -1},
//                {1, 0, 1}
//                "--------------"
//                {1, -1, 0},
//                {2, -1, 0},
//                "--------------"
                {1, -1, 0},
                {2, -1, 0},
                {4, -1, 0}
        };

        String[] result = solution(line);
        for (String r : result) {
            System.out.println(r);
        }
    }

    private static String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersaction = intersaction(line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]);
                if (intersaction != null) {
                    points.add(intersaction);
                }
            }
        }

        Point minPoint = getMinIntersaction(points);
        Point maxPoint = getMaxIntersaction(points);
        int width = getWidth(maxPoint.x, minPoint.x);
        int height = getHeight(maxPoint.y, minPoint.y);

        char[][] board = new char[height][width];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x = (int) (p.x - minPoint.x);
            int y = (int) (maxPoint.y - p.y);
            board[y][x] = '*';
        }

        String[] result = new String[board.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(board[i]);
        }
        return result;
    }

    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Point intersaction(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) ((b1 * c2) - (c1 * b2)) / ((a1 * b2) - (a2 * b1));
        double y = (double) ((a2 * c1) - (a1 * c2)) / ((a1 * b2) - (a2 * b1));

        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    private static Point getMinIntersaction(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Point(x, y);
    }

    private static Point getMaxIntersaction(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }

        return new Point(x, y);
    }

    private static int getWidth(long maxX, long minX) {
        return (int) (maxX - minX + 1);
    }

    private static int getHeight(long maxY, long minY) {
        return (int) (maxY - minY + 1);
    }
}






