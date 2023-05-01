package codingtest.test.level2;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class 괄호_회전하기 {
    public static void main(String[] args) {
        String s = "[)(]";
        int result = solution(s);
        System.out.println("result = " + result);
    }

    private static int solution(String s) {
        List<Character> letterList = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            letterList.add(letterList.remove(0));
            if (isCorrect(letterList)) count++;
        }
        return count;
    }


    private static boolean isCorrect(List<Character> letters) {
        Stack<Character> stack = new Stack<>();
        for (Character letter : letters) {
            if (letter == '[' || letter == '{' || letter == '(') stack.push(letter);
            else {
                if (stack.isEmpty()) return false;

                if (letter == ']' && stack.peek().equals('[')) stack.pop();
                else if (letter == '}' && stack.peek().equals('{')) stack.pop();
                else if (letter == ')' && stack.peek().equals('(')) stack.pop();
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
