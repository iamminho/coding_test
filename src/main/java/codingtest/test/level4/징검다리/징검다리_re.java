package codingtest.test.level4.징검다리;

import java.util.Arrays;

public class 징검다리_re {
    class Solution {
        public int solution(int distance, int[] rocks, int n) {
            int[] newRocks = Arrays.copyOf(rocks, rocks.length + 1);
            newRocks[newRocks.length - 1] = distance;
            Arrays.sort(newRocks);

            return binarySearch(newRocks, n);
        }

        private int binarySearch(int[] rocks, int n) {
            int start = 1;
            int end = 1000000000;

            while (end - start > 1) {
                int mid = (start + end) / 2;
                if (isValid(rocks, n, mid)) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

            return start;
        }

        private boolean isValid(int[] rocks, int n, int between) {
            int last = 0;
            int removed = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - last >= between) {
                    last = rocks[i];
                } else {
                    removed++;
                }
            }

            if (removed > n) return false;
            return true;
        }
    }
}
