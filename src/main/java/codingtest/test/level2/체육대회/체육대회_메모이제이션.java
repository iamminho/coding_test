package codingtest.test.level2.체육대회;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 체육대회_메모이제이션 {
    public static void main(String[] args) {
        int[][] ability = new int[][]{
                {40, 10, 10},
                {20, 5, 0},
                {30, 30, 30},
                {70, 0, 70},
                {100, 100, 100}
        };

        int answer = solution(ability);
        System.out.println("answer = " + answer);
    }

    public static int solution(int[][] ability) {
        return max(0, new boolean[ability.length], ability);
    }

    private static final Map<String, Integer> mem = new HashMap<>();

    private static int max(int student, boolean[] isChosen, int[][] ability) {
        if (student == ability.length) return 0;
        String memKey = toString(student, isChosen);
        if (mem.containsKey(memKey)) return mem.get(memKey);

        // 학생이 종목을 선택하지 않았을 경우
        int max = max(student + 1, isChosen, ability);

        for (int i = 0; i < ability[student].length; i++) {
            if (isChosen[i]) continue;
            isChosen[i] = true;
            int score = max(student + 1, isChosen, ability) + ability[student][i];
            max = Math.max(score, max);
            isChosen[i] = false;
        }

        mem.put(memKey, max);
        return max;
    }

    private static String toString(int student, boolean[] isChosen) {
        return student + Arrays.toString(isChosen);
    }
}
