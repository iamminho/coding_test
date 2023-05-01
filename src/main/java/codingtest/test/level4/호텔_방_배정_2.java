package codingtest.test.level4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* <번호를 찾는 방법>
  1. 재귀함수를 이용한다.
  *     만약 특정 수가 map에 있다면
  *         1. map의 values를 반환한다.
  *         2. values를 재귀시킨다.
  *     만약 특정 수가 없다면
  *         num, num + 1을 등록한다.
  *
*
*
* */

// 이 방법은 시간초과가 난다. 그러므로 유니온 파인드를 이용한다.
public class 호텔_방_배정_2 {
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = new long[]{1, 3, 4, 1, 3, 1};
        long[] answer = solution(k, room_number);
        for (long num : answer) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static long[] solution(long k, long[] room_number) {
        Map<Long, Long> numbers = new HashMap<>();

        return Arrays.stream(room_number)
                .map(num -> find(num, numbers))
                .toArray();
    }

    private static Long find(long rn, Map<Long, Long> numbers) {
        if (!numbers.containsKey(rn)) {
            numbers.put(rn, rn + 1);
            return rn;
        } else {
            long findNumber = find(numbers.get(rn), numbers);
            numbers.put(findNumber, findNumber + 1);
            return findNumber;
        }
    }
}
