package codingtest.test.level0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A로_B만들기 {
    public static void main(String[] args) {
        String before = "allpe";
        String after = "apple";
        int result = solution(before, after);
        System.out.println("result = " + result);
    }

    private static int solution(String before, String after) {
        return streamMap(before).equals(toMap(after)) ? 1 : 0;
    }

    private static Map<Character, Integer> toMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        return map;
    }

    private static Map<String, Long> streamMap(String word) {
        return Arrays.stream(word.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ));
    }
}
