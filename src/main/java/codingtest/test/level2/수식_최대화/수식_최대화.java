package codingtest.test.level2.수식_최대화;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수식_최대화 {
    class Solution {
        private String[][] signs = {
                {"+", "-", "*"},
                {"+", "*", "-"},
                {"-", "+", "*"},
                {"-", "*", "+"},
                {"*", "+", "-"},
                {"*", "-", "+"}
        };

        public long solution(String expression) {
            StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
            List<String> tokens = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                tokens.add(tokenizer.nextToken());
            }

            return calculate(tokens);
        }

        private long calculate(List<String> tokens) {
            long max = Long.MIN_VALUE;

            for (String[] sign : signs) {
                List<String> copy = copyTokens(tokens);
                calculate(sign, copy);
                long value = Math.abs(Long.parseLong(copy.get(0)));
                max = Math.max(max, value);
            }
            return max;
        }

        private void calculate(String[] sign, List<String> tokens) {
            for (String s : sign) {
                calculate(s, tokens);
            }
        }

        private void calculate(String s, List<String> tokens) {
            while (tokens.indexOf(s) != -1) {
                int idx = tokens.indexOf(s);
                long left = Long.parseLong(tokens.get(idx - 1));
                long right = Long.parseLong(tokens.get(idx + 1));
                long number = 0;

                switch (s) {
                    case "+":
                        number = left + right;
                        break;
                    case "-":
                        number = left - right;
                        break;
                    case "*":
                        number = left * right;
                        break;
                }

                for (int i = 0; i < 3; i++) tokens.remove(idx - 1);
                String newToken = Long.toString(number);
                tokens.add(idx - 1, newToken);
            }
        }

        private List<String> copyTokens(List<String> tokens) {
            List<String> result = new ArrayList<>();

            for (String token : tokens) {
                result.add(token);
            }
            return result;
        }
    }
}
