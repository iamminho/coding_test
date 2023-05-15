package codingtest.test.level2.카펫;

public class 카펫 {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        int[] result = solution(brown, yellow);
        System.out.println(result[0] + ", " + result[1]);
    }

    private static int[] solution(int brown, int yellow) {
        int[] result = getSize(brown, yellow);
        return result;
    }

    private static int[] getSize(int brown, int yellow) {
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int need = getBrownNum(i, yellow / i);
                if (need == brown) return new int[]{yellow / i + 2, i + 2};
            }
        }
        return new int[2];
    }

    private static int getBrownNum(int x, int y) {
        return x * 2 + y * 2 + 4;
    }
}
