package codingtest.test.level1.외톨이_알파벳;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class 외톨이_알파벳 {
    class Solution {
        public String solution(String input_string) {
            Set<Character> answer = new HashSet<>();

            Stack<Character> stack = new Stack<>();

            for (char c : input_string.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() != c) {
                    if (stack.search(c) != -1) {
                        answer.add(c);
                    }
                }
                stack.add(c);
            }

            if (answer.isEmpty()) return "N";

            return answer.stream()
                    .map(Object::toString)
                    .sorted()
                    .collect(Collectors.joining());
        }
    }
}
