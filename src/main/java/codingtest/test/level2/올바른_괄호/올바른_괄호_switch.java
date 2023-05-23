package codingtest.test.level2.올바른_괄호;

import java.util.Stack;

public class 올바른_괄호_switch {
    class Solution {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
//                switch (c) {
//                    case '(' -> stack.add('(');
//                    case ')' -> {
//                        if (stack.isEmpty()) return false;
//                        stack.pop();
//                    }
//                }
            }

            return stack.isEmpty();
        }
    }
}

// JDK 11에서는 switch 지원 안되서 주석으로 처리
