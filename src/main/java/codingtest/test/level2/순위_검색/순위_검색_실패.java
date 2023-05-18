package codingtest.test.level2.순위_검색;

import java.util.*;

public class 순위_검색_실패 {
    class Solution {
        public List<Integer> solution(String[] infos, String[] querys) {
            List<Integer> answer = new ArrayList<>();
            Map<String, List<Integer>> map = new HashMap<>();

            for (String info : infos) {
                getInfoMap(0, info.split(" "), "", map);
            }

            // System.out.println(map);
            // System.out.println("------------");

            for (String query : querys) {
                int number = Integer.parseInt(query.replaceAll("[^\\d]", ""));
                String template = query.replaceAll(" and |\\d+|\\s", "");
                //System.out.println(template);
                if (!map.containsKey(template)) {
                    answer.add(0);
                    continue;
                }
                List<Integer> numbers = map.get(template);
                int result = binarySearch(numbers, number);
                //System.out.println(numbers + ", " + number + "/ " + result);
                answer.add(result);
            }

            return answer;
        }

        private void getInfoMap(int level, String[] info, String selectedInfo,
                                Map<String, List<Integer>> map) {
            if (level == 4) {
                if (!map.containsKey(selectedInfo)) {
                    map.put(selectedInfo, new ArrayList<>());
                }
                map.get(selectedInfo).add(Integer.parseInt(info[4]));
                return;
            }

            getInfoMap(level + 1, info, selectedInfo + info[level], map);
            getInfoMap(level + 1, info, selectedInfo + "-", map);
        }

        private int binarySearch(List<Integer> numbers, int number) {
            Collections.sort(numbers);
            int start = 0;
            int end = numbers.size() - 1;

            while (end > start) {
                int mid = (start + end) / 2;

                if (numbers.get(mid) >= number) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            if (numbers.size() == 1 && numbers.get(0) < number) return 0;
            return numbers.size() - start;
        }
    }
}
