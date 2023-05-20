package codingtest.test.level2.피보나치_수;

import java.util.Arrays;

public class 피보나치_수_2 {
    int[] memory;

    public int solution(int n) {
        memory = new int[100001];
        Arrays.fill(memory, -1);

        return fibonacci(n);
    }

    private int fibonacci(int n) {
        if (memory[n] != -1) return memory[n];
        if (n == 0 || n == 1) return n;

        int sum = (fibonacci(n - 2) + fibonacci(n - 1)) % 1234567;

        memory[n] = sum;

        return sum;
    }
}
