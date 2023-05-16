package codingtest.test.level2.소수찾기;

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기_re {

    public static void main(String[] args) {
        String nums = "049";
        int result = solution(nums);
        System.out.println("result = " + result);
    }

    private static int solution(String nums) {
        Set<Integer> primes = new HashSet<>();
        int[] numbers = nums.chars()
                .map(c -> c - '0')
                .toArray();

        getPrimes(0, numbers, new boolean[numbers.length], primes);
        return primes.size();
    }

    private static Set<Integer> getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes) {
        if (isPrime(acc)) primes.add(acc);

        for (int i = 0; i < numbers.length; i++) {

            if (isUsed[i]) continue;

            int nextAcc = acc * 10 + numbers[i];
            isUsed[i] = true;
            primes.addAll(getPrimes(nextAcc, numbers, isUsed, primes));
            isUsed[i] = false;
        }

        return primes;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
