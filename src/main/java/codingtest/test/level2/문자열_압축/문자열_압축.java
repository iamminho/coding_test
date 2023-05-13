package codingtest.test.level2.문자열_압축;

import java.util.LinkedList;
import java.util.List;

public class 문자열_압축 {
    /*
     * subString을 이용하여 문자열을 1~str.length()(칸 개수)만큼 자른다.
     * 자른 문자열의 앞뒤를 비교해가며 count를 붙여준다.
     * 각 칸 개수의 문자열 길이를 비교하여 가장 작은 문자열의 길이를 반환한다.
     *
     * 필요한 기능
     * 1. 칸 개수만큼 문자열을 자르는 기능
     * 2. 자른 문자열의 앞뒤를 비교하여 count를 붙여 길이를 반환하는 기능
     */

    public static void main(String[] args) {
        String s = "xababcdcdababcdcd";
        int result = solution(s);
        System.out.println("result = " + result);
    }

    private static int solution(String s) {
        int strLength = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length(); i++) {
            List<String> splited = split(i, s);
            int pressed = press(splited);
            if (strLength > pressed) strLength = pressed;
        }
        return strLength;
    }

    private static List<String> split(int n, String s) {
        List<String> splited = new LinkedList<>();

        for (int i = 0; i < s.length(); i += n) {
            int endIdx = i + n;
            if (endIdx > s.length()) endIdx = s.length();
            String subString = s.substring(i, endIdx);
            splited.add(subString);
        }

        return splited;
    }

    private static int press(List<String> splited) {
        StringBuilder builder = new StringBuilder();
        String last = "";
        int count = 0;

        for (String s : splited) {
            if (last.equals(s)) {
                count++;
            } else {
                if (count > 1) builder.append(count);
                builder.append(last);
                last = s;
                count = 1;
            }
        }

        if (count > 1) builder.append(count);
        builder.append(last);

        return builder.length();
    }
}
