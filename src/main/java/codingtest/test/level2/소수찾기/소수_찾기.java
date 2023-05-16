package codingtest.test.level2.소수찾기;

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {
    /*
     * 71 -> 17, 71,
     * 011 -> 11, 101,
     * 제귀함수로 하면 안되나?
     * 이게 왜 완전탐색?
     * -> 제귀함수로 해본다.
     * 점화식: 일의자리가 소수 -> 십의자리로 -> 십의자리가 소수면 백의자리로
     * 탈출 방법은 numbers의 자릿수
     * */

    private static int[] check;
    private static char[] values;
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        String numbers = "011";
        int result = solution(numbers);
        System.out.println("result = " + result);

    }

    private static int solution(String numbers) {
        values = numbers.toCharArray();
        check = new int[numbers.length()];
        dfs("");
        return set.size();
    }

    private static void dfs(String cur) {
        for (int i = 0; i < values.length; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                if (isDecimal(cur + values[i])) {
                    System.out.println("cur + values[i] = " + cur + values[i]);
                    set.add(Integer.parseInt(cur + values[i]));
                }
                dfs(cur + values[i]);
                check[i] = 0;
            }
        }
    }

    private static boolean isDecimal(String str) {
        int number = Integer.parseInt(str);
        int sqrt = (int) Math.sqrt(number);

        if (number <= 1) return false;
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
