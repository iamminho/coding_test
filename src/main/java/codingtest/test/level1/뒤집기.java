package codingtest.test.level1;

public class 뒤집기 {
    public static void main(String[] args) {
        int n = 125;
        int result = solution(n);
        System.out.println("result = " + result);
    }

    public static int solution(int n) {
        String v = Integer.toString(n, 3);
        System.out.println("v = " + v);
        String reversed = new StringBuffer(v).reverse().toString();
        System.out.println("reversed = " + reversed);
        int number = Integer.parseInt(reversed, 3);
        return number;

    }
}
