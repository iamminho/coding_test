package codingtest.test.level1;

import java.util.Arrays;

public class 문자열_내_맘대로_정렬하기 {
    public static void main(String[] args) {
        String[] strings = new String[]{"sun", "bed", "cars", "mon"};
        int n = 2;
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2);
            }
            return s1.charAt(n) - s2.charAt(n);
        });

        for (String string : strings) {
            System.out.println(string + " ");
        }
    }
}
