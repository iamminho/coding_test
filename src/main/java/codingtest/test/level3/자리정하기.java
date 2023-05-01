package codingtest.test.level3;

import java.util.*;
import java.util.stream.IntStream;

public class 자리정하기 {
    private static Set<String> set = new HashSet<>();
    private static int caseNumber;
    private static int[][] board;
    private static int answer = 0;

    private static int[] teamNumber;
    private static Map<Integer, Integer> map;

    public static void main(String[] args) {
        String[] teams = new String[]{"A B C", "C D", "E"};
        int r = 2;
        int c = 3;
        int result = solution(teams, r, c);
        System.out.println("result = " + result);
    }

    private static int solution(String[] teams, int r, int c) {
        caseNumber = getCaseNumber(teams);
        board = new int[r][c];
        setTeamNumber(teams);
        map = setMap(teams);
        //System.out.println("map = " + map);


        dfs(0, 0, 0);
        System.out.println("set = " + set);


        return answer;
    }

    private static int getCaseNumber(String[] teams) {
        return Arrays.stream(teams)
                .mapToInt(team -> team.split(" ").length)
                .reduce(1, (a, b) -> a * b);
    }

    private static Map<Integer, Integer> setMap(String[] teams) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < teams.length; i++) {
            map.put(i + 1, teams[i].split(" ").length);
        }

        return map;
    }


    private static void setTeamNumber(String[] teams) {
        int[] result = new int[teams.length];

        for (int i = 0; i < teams.length; i++) {
            result[i] = i + 1;
        }

        teamNumber = result;
    }

    private static void dfs(int level, int x, int y) {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        int[] availTeam = findTeam(x, y, teamNumber);
        //printTeam(availTeam);


        for (int team : availTeam) {
            if (map.get(team) <= 0) continue;
            map.put(team, map.get(team) - 1);

            board[y][x] = team;
            //printBoard(board);


            if (level == board.length * board[0].length - 1) {
                String result = toString(board);
                if (!set.contains(result)) {
                    set.add(result);
                    answer += caseNumber;
                }
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx >= 0 && nx < board[0].length && ny >= 0 && ny < board.length && board[ny][nx] == 0) {
                    dfs(level + 1, nx, ny);
                }
            }
            board[y][x] = 0;
            map.put(team, map.get(team) + 1);
        }
    }

    private static int[] findTeam(int x, int y, int[] teamNumber) {
        boolean[] check = new boolean[teamNumber.length + 1];

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        for (int i = 0; i < dx.length; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;


            if (nx >= 0 && nx < board[0].length && ny >= 0 && ny < board.length && board[ny][nx] != 0) {
                int teamNum = board[ny][nx];
                check[teamNum] = true;
            }
        }

        return IntStream.range(1, check.length)
                .filter(i -> !check[i])
                .toArray();
    }

    private static String toString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(Integer.toString(board[i][j]));
            }
        }
        return sb.toString();
    }

    private static void printTeams(String[][] splitTeams) {
        for (String[] team : splitTeams) {
            System.out.print(Arrays.toString(team) + " ");
        }
        System.out.println();
    }

    private static void printBoard(int[][] board) {
        System.out.println("<board>");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printTeam(int[] team) {
        System.out.println("<team>");
        for (int s : team) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void printCheck(boolean[][] check) {
        System.out.println("<check>");
        for (boolean[] c : check) {
            for (boolean b : c) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

    }

}
