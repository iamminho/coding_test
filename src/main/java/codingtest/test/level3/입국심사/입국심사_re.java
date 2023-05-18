package codingtest.test.level3.입국심사;

import java.util.Arrays;

public class 입국심사_re {
    class Solution {
        public long solution(int n, int[] times) {
            long result = binarySearch(n, times);
            return result;
        }

        private long binarySearch(int n, int[] times) {
            long start = 1;
            long end = 1000000000000000000L;

            while (start < end) {
                long mid = (start + end) / 2;
                long people = getPeople(mid, times);
                if (people < n) {
                    start = mid + 1;
                } else end = mid;
            }

            return end;
        }

        private long getPeople(long minute, int[] times) {
            return Arrays.stream(times)
                    .mapToLong(time -> minute / time)
                    .sum();
        }
    }
}
