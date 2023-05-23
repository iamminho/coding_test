package codingtest.test.level2.기능개발;

import java.util.ArrayList;
import java.util.List;

public class 기능개발_2 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> answer = new ArrayList<>();

            for (int i = 0; i < progresses.length; i++) {
                int time = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);

                int start = i;
                for (int j = i; j < progresses.length; j++) {
                    progresses[j] += time * speeds[j];
                }

                int cnt = 0;
                for (int k = start; k < progresses.length; k++) {
                    if (progresses[k] >= 100) cnt++;
                    else break;
                }

                i += cnt - 1;
                answer.add(cnt);
            }
            return answer.stream()
                    .mapToInt(v -> v)
                    .toArray();
        }
    }
}
