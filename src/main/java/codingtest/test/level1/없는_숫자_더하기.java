package codingtest.test.level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 없는_숫자_더하기 {
    public static void main(String[] args) {
        int result = 0;
        int[] numbers = new int[]{1, 2, 3, 4, 6, 7, 8, 0};
        List<Integer> newNumbers = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        for (int i = 0; i <= 9; i++) {
            if (!newNumbers.contains(i)) result += i;
        }

        System.out.println("result = " + result);
    }
}
