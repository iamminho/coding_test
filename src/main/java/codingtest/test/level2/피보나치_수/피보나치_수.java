package codingtest.test.level2.피보나치_수;

import java.util.Arrays;

public class 피보나치_수 {
    private static long[] mem;

    public static void main(String[] args) {
        int n = 100;
        mem = new long[n + 1];
        Arrays.fill(mem, -1);
        for (int i = 0; i <= n; i++) {
            fibonacci(n);
        }

        long result = fibonacci(n);
        System.out.println("result = " + result);


    }

    private static long fibonacci(int n) {
        if (mem[n] != -1) return mem[n];
        if (n == 0 || n == 1) return n;
        return mem[n] = fibonacci(n - 1) + fibonacci(n - 2) % 1234567;
    }
}
