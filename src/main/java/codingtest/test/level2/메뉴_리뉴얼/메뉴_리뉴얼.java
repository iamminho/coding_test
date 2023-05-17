package codingtest.test.level2.메뉴_리뉴얼;

import java.util.*;

public class 메뉴_리뉴얼 {
    /*
     * 1. 가능한 모든 알파뱃을 알아낼것
     * 2. 알파벳의 조합을 알아낼것
     * 3. 개수에 따른 알파뱃 조합
     *      - 계속 순위를 업데이트 할것

     */
    private static String[] orders;

    public static void main(String[] args) {
        orders = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] courses = new int[]{2, 3, 4};

        String[] alphabets = getAllAlphabet(orders);

        List<String> courseList = new ArrayList<>();
        for (int course : courses) {
            Map<String, Integer> orderMap = new HashMap<>();
            combination(0, course, 0, alphabets, new boolean[alphabets.length], orderMap);
            if (!orderMap.isEmpty()) {
                Integer maxValue = Collections.max(orderMap.values());
                orderMap.entrySet().stream()
                        .filter(entry -> entry.getValue() == maxValue)
                        .map(entry -> entry.getKey())
                        .forEach(value -> courseList.add(value));
            }
        }

        Collections.sort(courseList);
        System.out.println("courseList = " + courseList);
    }

    private static String[] getAllAlphabet(String[] orders) {
        Set<String> set = new HashSet();
        for (String order : orders) {
            char[] array = order.toCharArray();
            for (char c : array) {
                set.add(String.valueOf(c));
            }
        }

        return set.toArray(String[]::new);
    }

    private static void combination(int l, int r, int start, String[] alphabets, boolean[] visited, Map<String, Integer> orderMap) {
        if (l == r) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) builder.append(alphabets[i]);
            }

            int count = 0;
            for (String order : orders) {
                boolean isContain = builder.toString()
                        .chars()
                        .allMatch(c -> order.contains(String.valueOf((char) c)));
                if (isContain) count++;
            }
            if (count >= 2) orderMap.put(builder.toString(), count);
            return;
        }
        for (int i = start; i < alphabets.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(l + 1, r, i + 1, alphabets, visited, orderMap);
                visited[i] = false;
            }
        }
    }
}


