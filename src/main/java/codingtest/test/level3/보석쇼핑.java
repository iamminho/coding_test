package codingtest.test.level3;

import java.util.*;

public class 보석쇼핑 {
    public static void main(String[] args) {
        String[] gems = new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] answer = solution(gems);
        System.out.println("answer[0] = " + answer[0]);
        System.out.println("answer[1] = " + answer[1]);
    }

    private static int[] solution(String[] gems) {

        int start = 0;
        int end = gems.length - 1;
        Set<String> gemSet = new HashSet<>(List.of(gems));

        int s = 0;
        int e = s;
        Map<String, Integer> includes = new HashMap<>();
        includes.put(gems[s], 1);

        while (s < gems.length) {
            if (includes.keySet().size() == gemSet.size()) {
                if (e - s < end - start) {
                    start = s;
                    end = e;
                }
                includes.put(gems[s], includes.get(gems[s]) - 1);
                if (includes.get(gems[s]) == 0) {
                    includes.remove(gems[s]);
                }
                s++;
            } else if (e < gems.length - 1) {
                e++;
                includes.put(gems[e], includes.getOrDefault(gems[e], 0) + 1);
            } else {
                break;
            }
        }

        return new int[]{start + 1, end + 1};
    }
}
