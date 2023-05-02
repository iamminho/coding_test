package codingtest.test.level2;

import java.util.Arrays;

public class k진수에서_소수_개수_구하기_2 {
    public static void main(String[] args) {
        int n = 110011;
        int k = 10;
        System.out.println("answer = " + solution(n, k));
    }
    public static int solution(long n, int k) {
        String[] tokens = Long.toString(n, k).split("0+");

        int count = 0;
        for (String token : tokens) {
            if (isPrime(Long.parseLong(token))) count++;
        }

        return count;
    }

    private static boolean isPrime(long v) {
        if (v <= 1) return false;
        for (long i = 2; i * i <= v; i++) {
            if (v % i == 0) return false;
        }
        return true;
    }

}
