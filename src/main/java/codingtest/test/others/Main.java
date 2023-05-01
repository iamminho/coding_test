package codingtest.test.others;

public class Main {
    public static class Count {
        private final int zero;
        private final int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) {
            return new Count(zero + other.zero, one + other.one);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1},
        };

        int[] result = solution(arr);
        System.out.println(result[0] + " , " + result[1]);
    }

    public static int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[]{count.zero, count.one};
    }

    public static Count count(int offsetX, int offsetY, int size, int[][] arr) {
//        System.out.println("offsetX = " + offsetX);
//        System.out.println("offsetY = " + offsetY);
//        System.out.println("di = " + size);
//        System.out.println("------------------");

        int h = size / 2;
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[x][y] != arr[offsetX][offsetY]) {
                    return count(offsetX, offsetY, h, arr)
                            .add(count(offsetX + h, offsetY, h, arr))
                            .add(count(offsetX, offsetY + h, h, arr))
                            .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }
        if (arr[offsetX][offsetY] == 1) return new Count(0, 1);
        return new Count(1, 0);
    }
}