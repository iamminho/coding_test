package codingtest.test.level2;

import java.util.Stack;

public class 올바른_괄호 {
    public static void main(String[] args) {
        String s = "(()(";
        boolean result = solution(s);
        System.out.println("result = " + result);
    }

    private static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return true;
    }

//    boolean solution(String s) {
//        int count  = 0;
//        for (char c : s.toCharArray()) {
//            if (c == '(') count++;
//            else {
//                count--;
//                if (count < 0) return false;
//            }
//        }
//
//        if (count != 0) return false;
//        return true;
//    }


}
