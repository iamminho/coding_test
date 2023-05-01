package codingtest.test.level2;

import java.util.Stack;
import java.util.stream.Collectors;

public class 큰_수_만들기_2 {
    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        String answer = solution(number, k);
        System.out.println("answer = " + answer);
    }

    private static String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && c > stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (k-- > 0) {
            stack.pop();
        }

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
