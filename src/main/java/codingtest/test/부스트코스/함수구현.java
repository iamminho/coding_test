package codingtest.test.부스트코스;

import java.util.HashMap;
import java.util.Map;


public class 함수구현 {
    public int[] overlap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .mapToInt(entry -> entry.getValue())
                .toArray();

        if (result.length == 0) return new int[]{-1};
        return result;
    }
}
