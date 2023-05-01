package codingtest.test.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class 체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = new int[]{1, 2, 4};
        int[] reserve = new int[]{2, 3, 5, 6};
        int answer = solution(n, lost, reserve);
        System.out.println("answer = " + answer);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // owns는 lost와 reserve의 교집합
        Set<Integer> owns = getOwns(lost, reserve);

        Queue<Integer> q = new LinkedList<>();
        for (int l : lost) q.add(l);

        int get = 0;
        for (int r : reserve) {
            if (owns.contains(r)) continue;

            // r - 1에 속하지 않는 것들은 제거한다.
            while (!q.isEmpty() && (q.peek() < r - 1 || owns.contains(q.peek()))) {
                q.poll();
            }

            if (q.isEmpty()) break;

            // r + 1의 범위에 속하는 것들은 제거한뒤 get++시켜준다.
            if (q.peek() <= r + 1) {
                q.poll();
                get++;
            }
        }

        return n - lost.length + owns.size() + get;
    }

    public static Set<Integer> getOwns(int[] lost, int[] reserve) {
        Set<Integer> owns = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toSet());

        owns.retainAll(Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toSet()));

        return owns;
    }
}
