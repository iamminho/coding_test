package codingtest.test.level1;

public class 숫자_문자열과_영단어 {
    /*
     * zero부터 nine까지 replace를 시도한다.
     * */

    private static String[] numbers = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) {
        String s = "one4seveneight";
        int result = solution(s);
        System.out.println("result = " + result);

    }

    public static int solution(String s) {
        for (int i = 0; i < numbers.length; i++) {
            s = s.replace(numbers[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}
