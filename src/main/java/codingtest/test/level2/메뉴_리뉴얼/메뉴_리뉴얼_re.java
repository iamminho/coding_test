package codingtest.test.level2.메뉴_리뉴얼;

import java.util.*;
import java.util.stream.Collectors;

public class 메뉴_리뉴얼_re {
    class Solution {
        public List<String> solution(String[] ex, int[] course) {
            String[] orders = Arrays.stream(ex)
                    .map(order -> order.chars()
                            .sorted()
                            .mapToObj(c -> String.valueOf((char) c))
                            .collect(Collectors.joining()))
                    .toArray(String[]::new);

            List<String> result = new ArrayList<>();
            for (int c : course) {
                Map<String, Integer> map = new HashMap<>();
                for (String order : orders) {
                    combination(order, 0, "", c, map);
                }
                result.addAll(getMaxValue(map));
            }

            Collections.sort(result);

            return result;
        }

        private void combination(String order, int idx, String course, int end,
                                 Map<String, Integer> map) {

            if (course.length() == end) {
                map.put(course, map.getOrDefault(course, 0) + 1);
                return;
            }

            for (int i = idx; i < order.length(); i++) {
                combination(order, i + 1, course + order.charAt(i), end, map);
            }
        }

        private List<String> getMaxValue(Map<String, Integer> map) {
            List<String> repo = new ArrayList<>();
            int max = 2;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (max < entry.getValue()) {
                    repo.clear();
                    repo.add(entry.getKey());
                    max = entry.getValue();
                } else if (max == entry.getValue()) {
                    repo.add(entry.getKey());
                }
            }

            return repo;
        }
    }
}
