package codingtest.test.level2.기능개발;

import java.util.Arrays;

public class 기능개발_others {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] dayOfend = new int[101];
            int day = 0;

            for (int i = 0; i < progresses.length; i++) {
                while (progresses[i] + (day * speeds[i]) <= 100) {
                    day++;
                }
                dayOfend[day]++;
            }

            return Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
        }
    }
}
