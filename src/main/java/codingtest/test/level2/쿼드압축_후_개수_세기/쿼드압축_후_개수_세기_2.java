package codingtest.test.level2.쿼드압축_후_개수_세기;

public class 쿼드압축_후_개수_세기_2 {
    private class Count {
        int zero;
        int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count count) {
            return new Count(zero + count.zero, one + count.one);
        }
    }

    public int[] solution(int[][] arr) {
        int[] answer = {};
        Count result = press(0, 0, arr.length, arr);
        return new int[]{result.zero, result.one};
    }

    private Count press(int offsetX, int offsetY, int size, int[][] arr) {
        int number = arr[offsetY][offsetX];
        int h = size / 2;

        if (size == 1) {
            if (number == 1) return new Count(0, 1);
            else return new Count(1, 0);
        }

        if (isQuard(offsetX, offsetY, size, arr)) {
            if (number == 1) return new Count(0, 1);
            else return new Count(1, 0);
        }

        return press(offsetX, offsetY, h, arr)
                .add(press(offsetX + h, offsetY, h, arr))
                .add(press(offsetX, offsetY + h, h, arr))
                .add(press(offsetX + h, offsetY + h, h, arr));
    }

    private boolean isQuard(int offsetX, int offsetY, int size, int[][] arr) {
        for (int i = offsetY; i < offsetY + size; i++) {
            for (int j = offsetX; j < offsetX + size; j++) {
                if (arr[i][j] != arr[offsetY][offsetX]) return false;
            }
        }
        return true;
    }
}
