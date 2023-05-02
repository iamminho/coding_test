package codingtest.test.level2;

import java.util.Arrays;

public class k진수에서_소수_개수_구하기 {
    public int solution(long n, int k) {
        int answer = 0;
        String number = Long.toString(n, k);
        String[] numbers = Arrays.stream(number.split("0"))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        for (String s : numbers) {
            if (isDecimal(s)) answer++;
        }

        return answer;
    }

    private boolean isDecimal(String s) {
        long number = Long.parseLong(s);
        if (number == 1) return false;
        if (number == 2) return true;
        for (long i = 2; i < (long) (Math.sqrt(number)) + 1; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
