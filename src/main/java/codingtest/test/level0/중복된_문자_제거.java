package codingtest.test.level0;

import java.util.HashSet;
import java.util.Set;

public class 중복된_문자_제거 {
    public static void main(String[] args) {
        String myString = "people are bad";
        String result = solution(myString);
        System.out.println("result = " + result);
    }

    private static String solution(String myString) {
        char[] strings = myString.toCharArray();
        Set<Character> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (char c : strings) {
            if (!set.contains(c)) builder.append(c);
            set.add(c);
        }
        return builder.toString();

    }
}
