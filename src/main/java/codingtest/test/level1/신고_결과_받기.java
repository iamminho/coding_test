package codingtest.test.level1;

import java.util.*;

public class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        setNames(report, reportMap);

        Map<String, Integer> idMap = new HashMap<>();
        setId(idMap, reportMap);

        return getResult(id_list, idMap, reportMap, k);
    }

    private void setNames(String[] report, Map<String, Set<String>> reportMap) {
        for (String name : report) {
            String[] names = name.split(" ");
            reportMap.computeIfAbsent(names[0], k -> new HashSet<>()).add(names[1]);
        }
    }

    private void setId(Map<String, Integer> idMap, Map<String, Set<String>> reportMap) {
        for (Map.Entry<String, Set<String>> entry : reportMap.entrySet()) {
            for (String name : entry.getValue()) {
                idMap.put(name, idMap.getOrDefault(name, 0) + 1);
            }
        }
    }

    private int[] getResult(String[] id_list, Map<String, Integer> idMap, Map<String, Set<String>> reportMap, int k) {
        List<Integer> result = new ArrayList<>();

        for (String id : id_list) {
            if (reportMap.get(id) != null) {
                String[] names = reportMap.get(id).toArray(new String[0]);
                int count = 0;
                for (String name : names) {
                    if (idMap.get(name) >= k) count++;
                }
                result.add(count);
            } else {
                result.add(0);
            }
        }


        return result.stream()
                .mapToInt(v -> v)
                .toArray();
    }
}
