package codingtest.test.level3.입국심사;

public class 입국심사 {
    public static void main(String[] args) {
        int[] times = new int[]{7, 10, 12};
        int n = 10;
        long result = binarySearch(times, n);
        System.out.println("result = " + result);
    }

    private static long binarySearch(int[] times, int n) {
        long start = 1;
        long end = 1000000000000000000L;

        while (end > start) {
            long mid = (start + end) / 2;
            if (isValid(times, mid, n)) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    private static boolean isValid(int[] times, long mid, int n) {
        long count = 0;
        for (int time : times) {
            count += mid / time;
        }
        return n <= count;
    }
}
