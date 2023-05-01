package codingtest.test.level1;

public class 문자열_다루기_기본 {
    public static void main(String[] args) {
        String s = "1234";
        boolean result = solution(s);
        System.out.println("result = " + result);
    }

    public static boolean solution(String s) {
        return (isNumber(s));
    }

    public static boolean isNumber(String s) {
        String regex = "[0-9]{4}|[0-9]{6}";
        if (s.matches(regex)) {
            return true;
        }
        return false;
    }
}
