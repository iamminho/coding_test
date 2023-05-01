package codingtest.test.level1;

import java.util.HashSet;
import java.util.Set;

public class 없는_숫자_더하기_2 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 6, 7, 8, 0};
        int result = solution(numbers);
        System.out.println("result = " + result);
    }

    private static int solution(int[] numbers) {
        Set<Integer> set = new HashSet<Integer>();
        for (int number : numbers) {
            set.add(number);
        }

        int count = 0;
        for (int i = 0; i <= 9; i++) {
            if (!set.contains(i)) count += i;
        }

        return count;
    }
}
