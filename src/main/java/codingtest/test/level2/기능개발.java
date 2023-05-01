package codingtest.test.level2;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progress = new int[]{1, 1, 1, 1};
        int[] speeds = new int[]{100, 50, 99, 100};
        int[] result = solution(progress, speeds);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int days = 0;
        int count = 0;
        for (int i = 0; i < progresses.length; i++) {
            int takeTime = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            if (takeTime > days) {
                if (days != 0) {
                    result.add(count);
                    count = 0;
                }
                days = takeTime;
            }
            count++;
        }

        if (count > 0) result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


}
