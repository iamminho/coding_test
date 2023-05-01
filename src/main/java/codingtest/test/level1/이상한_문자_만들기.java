package codingtest.test.level1;

public class 이상한_문자_만들기 {
    public static void main(String[] args) {
        String s = "try hello world";
        solution(s);
    }

    public static void solution(String s) {
        StringBuilder builder = new StringBuilder();
        String[] arr = s.split(" ");
        for (String value : arr) {
            builder.append(convertor(value));
            builder.append(" ");
        }
        System.out.println("builder = " + builder.deleteCharAt(builder.length() - 1).toString());
    }

    public static String convertor(String value) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char conv;
            if (i % 2 == 0) conv = Character.toUpperCase(value.charAt(i));
            else conv = Character.toLowerCase(value.charAt(i));
            builder.append(conv);
        }
        return builder.toString();
    }
}
