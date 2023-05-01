package codingtest.test.level2;

import java.util.*;

public class 메뉴_리뉴얼_3 {
    /*
     * wx 는 xw도 해당되어야 한다.
     * 즉, xw가 있는 문자라면 정렬해서 wx로 바꿔야 한다.
     * */
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = new int[]{2, 3, 4};
        List<String> result = solution(orders, course);
        System.out.println("result = " + result);
    }

    private static List<String> solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (int c : course) {
            Map<String, Integer> orderMap = new HashMap<>();
            for (String order : orders) {
                char[] orderElements = order.toCharArray();
                orderCombination(0, 0, c, orderElements, new boolean[orderElements.length], orderMap);
            }

            System.out.println("orderMap = " + orderMap);
            if (!orderMap.isEmpty()) setCourse(orderMap, result);
        }

        Collections.sort(result);
        return result;
    }

    private static void orderCombination(int level, int start, int end, char[] order, boolean[] visited, Map<String, Integer> orderMap) {
        if (level == end) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) result.add(String.valueOf(order[i]));
            }
            Collections.sort(result);
            String newCourse = String.join("", result);

            if (orderMap.get(newCourse) == null) orderMap.put(newCourse, 1);
            else orderMap.put(newCourse, orderMap.get(newCourse) + 1);
            return;
        }
        for (int i = start; i < order.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                orderCombination(level + 1, i + 1, end, order, visited, orderMap);
                visited[i] = false;
            }
        }
    }

    private static void setCourse(Map<String, Integer> orderMap, List<String> result) {
        Integer maxValue = Collections.max(orderMap.values());
        if (maxValue < 2) return;

        orderMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(entry -> entry.getKey())
                .forEach(value -> result.add(value));
    }
}
