package codingtest.test.level2.소수찾기;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기_1 {
    class Solution {
        public int solution(String numbers) {
            Set<Integer> set = new HashSet<>();
            boolean[] visited = new boolean[numbers.length()];
            decimal(numbers.toCharArray(), set, "", visited);
            return set.size();
        }

        private void decimal(char[] numbers, Set<Integer> set, String number, boolean[] visited) {
            if (number.length() >= 1 && isDecimal(number)) {
                set.add(Integer.parseInt(number));
            }

            for (int i = 0; i < numbers.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    decimal(numbers, set, number + numbers[i], visited);
                    visited[i] = false;
                }
            }
        }

        private boolean isDecimal(String number) {
            int num = Integer.parseInt(number);
            if (num <= 1) return false;

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }
}
