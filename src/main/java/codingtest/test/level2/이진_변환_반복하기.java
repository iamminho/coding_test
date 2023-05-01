package codingtest.test.level2;

public class 이진_변환_반복하기 {
    /*
     * 1. 0을 없앤다.
     * 2. 0을 없앤 문자열의 길이를 구한다.
     * 3. 0을 없앤 문자열을 2진법으로 변환한다.
     * 4. 제거된 0의 개수를 list에 추가한다.
     *
     * 필요기능
     * 0을 없애는 기능
     * 문자열을 2진법으로 변환하는 기능
     */

    public static void main(String[] args) {
        String s = "1111111";
        int[] result = solution(s);
        System.out.println("result = " + result);
    }

    public static int[] solution(String s) {
        int[] result;
        int count = 0;
        int zero = 0;
        while (true) {
            if (s.equals("1")) break;
            int tmp = s.length();
            s = deleteZero(s);
            zero += tmp - s.length();
            s = Integer.toString(s.length(), 2);
            count++;
        }
        result = new int[]{count, zero};
        return result;
    }

    private static String deleteZero(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '1') builder.append(c);
        }
        return builder.toString();
    }
}
