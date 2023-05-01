package codingtest.test.level2;

import java.util.Stack;

public class 큰_수_만들기 {
    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        String answer = solution(number, k);
        System.out.println("answer = " + answer);
    }

    private static String solution(String number, int k) {
        String[] numbers = number.split("");
        Stack<Integer> stack = new Stack<>();

        for (String num : numbers) {
            int value = Integer.parseInt(num);

            if (stack.isEmpty()) {
                stack.add(value);
                continue;
            }

            if (stack.peek() < value) {
                while (!stack.isEmpty() && k > 0 && stack.peek() < value) {
                    stack.pop();
                    k--;
                }
            }
            stack.add(value);
        }

        String answer = convert(stack);
        if (k > 0) {
            return answer.substring(0, answer.length() - 1);
        }
        return answer;
    }

    private static String convert(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
