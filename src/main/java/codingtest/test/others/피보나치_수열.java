package codingtest.test.others;

import java.util.Arrays;

public class 피보나치_수열 {
    private static int calls = 0;
    private static final long[] mem = new long[101];

    public static void main(String[] args) {
        Arrays.fill(mem, -1);
        System.out.println("fibonacci(10) = " + fibonacci(50));
        System.out.println("calls = " + calls);
    }

    private static long fibonacci(int n) {
        calls++;

        if (mem[n] != -1) return mem[n];
        if (n == 0 || n == 1) return n;
        return mem[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
