package codingtest.test.level1;

import java.util.HashSet;
import java.util.Set;

public class 두개_뽑아서_더하기 {
    public static void main(String[] args) {
        int[] numbers = {5, 0, 2, 7};
        int[] result = solution(numbers);
        for (int v : result) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    private static int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
