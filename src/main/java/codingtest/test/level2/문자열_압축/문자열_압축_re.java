package codingtest.test.level2.문자열_압축;

import java.util.Stack;

public class 문자열_압축_re {
    public int solution(String s) {
        int answer = 1000;
        if (s.length() == 1) return 1;

        for (int num = 1; num <= s.length() / 2; num++) {
            answer = Math.min(getPress(num, s), answer);
        }

        return answer;
    }

    private int getPress(int num, String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack();
        int count = 1;

        for (int i = 0; i < s.length(); i++) {
            String sub;
            if (i == s.length() - (s.length() % num)) sub = s.substring(i);
            else sub = s.substring(i, i + num);
            i = i + num - 1;

            if (stack.isEmpty()) {
                stack.push(sub);
                continue;
            }

            if (stack.peek().equals(sub)) {
                count++;
                continue;
            }

            if (!stack.peek().equals(sub)) {
                if (count > 1) {
                    sb.append(count);
                    count = 1;
                }

                sb.append(stack.pop());
                stack.push(sub);
            }
        }

        if (!stack.isEmpty()) {
            if (count > 1) sb.append(count);
            sb.append(stack.pop());
        }

        return sb.length();
    }
}
