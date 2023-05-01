package codingtest.test.level0;

public class 재귀_정의하기 {
    public static void main(String[] args) {
        int n = 2;
        int m = 2;

        int result = DFS(n, m);
        System.out.println("result = " + result);
    }

    public static int DFS(int n, int m) {
        if (n == 0) return 1;
        if (m == 0) return 1;
        if (n == 1) return 1;

        System.out.println("n = " + n);
        System.out.println("m = " + m);
        System.out.println("----------");

        return n * DFS(n, m - 1);
    }
}
