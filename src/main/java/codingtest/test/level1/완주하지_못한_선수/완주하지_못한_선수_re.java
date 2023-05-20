package codingtest.test.level1.완주하지_못한_선수;

import java.util.Arrays;

public class 완주하지_못한_선수_re {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            Arrays.sort(participant);
            Arrays.sort(completion);

            for (int i = 0; i < participant.length - 1; i++) {
                if (!participant[i].equals(completion[i])) return participant[i];
            }

            return participant[participant.length - 1];

        }
    }
}
