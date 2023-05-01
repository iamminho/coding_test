package codingtest.test.level2;

import java.util.Stack;

public class 괄호_회전하기2 {
    public static void main(String[] args) {
        String s = "[](){}";
        int result = solution(s);
        System.out.println("result = " + result);
    }

    private static int solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isCollect(s.toCharArray(), i)) count++;
        }
        return count;
    }

    private static boolean isCollect(char[] str, int offset) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            int idx = (i + offset) % str.length;
            char c = str[idx];
            if (c == '[' || c == '{' || c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return false;

                if (c == ']' && stack.peek().equals('[')) stack.pop();
                else if (c == '}' && stack.peek().equals('{')) stack.pop();
                else if (c == ')' && stack.peek().equals('(')) stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
