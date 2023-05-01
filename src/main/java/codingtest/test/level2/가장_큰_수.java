package codingtest.test.level2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장_큰_수 {
    public static void main(String[] args) {
        int[] numbers = new int[]{0, 0, 0};
        String result = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);
                    return reversed - original;
                })
                .collect(Collectors.joining(""))
                .replaceAll("^0+", "0"); // ex) numbers = {0, 0, 0};
        System.out.println("result = " + result);
    }
}
