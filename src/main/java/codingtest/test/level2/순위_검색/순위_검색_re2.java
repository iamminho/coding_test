package codingtest.test.level2.순위_검색;

import java.util.*;

public class 순위_검색_re2 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] answer = solution(info, query);
        System.out.println(Arrays.toString(answer));

    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();

        for (String s : info) {
            String[] data = s.split(" ");
            buildMap(0, data, "", map);
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");

            if (!map.containsKey(q[0])) {
                answer[i] = 0;
                continue;
            }

            answer[i] = binarySearch(map.get(q[0]), Integer.parseInt(q[1]));
        }

        return answer;
    }

    public static void buildMap(int index, String[] data, String selected, Map<String, List<Integer>> map) {
        if (index == 4) {
            if (!map.containsKey(selected)) {
                map.put(selected, new ArrayList<>());
            }
            map.get(selected).add(Integer.parseInt(data[4]));
            return;
        }
        buildMap(index + 1, data, selected + data[index], map);
        buildMap(index + 1, data, selected + "-", map);
    }

    public static int binarySearch(List<Integer> list, int score) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }
}
