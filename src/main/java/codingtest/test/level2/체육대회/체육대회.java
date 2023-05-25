package codingtest.test.level2.체육대회;

public class 체육대회 {
    class Solution {
        private int result = 0;

        public int solution(int[][] ability) {
            getMaxScore(0, 0, ability, new boolean[ability.length]);
            return result;
        }

        private void getMaxScore(int score, int event, int[][] ability, boolean[] visited) {
            if (event == ability[0].length) {
                result = Math.max(score, result);
                return;
            }

            for (int i = 0; i < ability.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    getMaxScore(score + ability[i][event], event + 1, ability, visited);
                    visited[i] = false;
                }
            }
        }
    }
}
