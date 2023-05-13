package codingtest.test.level2.문자열_압축;

public class 문자열_압축_re {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int num = 1; num <= s.length(); num++) {
            answer = Math.min(press(num, s), answer);
        }

        return answer;
    }

    private int press(int length, String s) {
        StringBuilder sb = new StringBuilder();
        String last = "";
        int count = 1;

        for (int start = 0; start < s.length(); start += length) {
            int end = start + length;
            if (end > s.length()) end = s.length();
            String sub = s.substring(start, end);

            if (!last.equals(sub)) {
                if (count > 1) {
                    sb.append(count);
                    count = 1;
                }
                sb.append(last);
                last = sub;
            } else count++;
        }

        if (count > 1) sb.append(count);
        sb.append(last);

        return sb.length();
    }
}
