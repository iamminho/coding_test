package codingtest.test.others;

import java.util.Arrays;
import java.util.stream.Stream;

public class 문자열_쪼개기1 {
    public static void main(String[] args) {
        String[] array = {"abide", "fesd", "uuid", "efgh"};
        String[] result = getDistinctLetters(array);
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static String[] getDistinctLetters(String[] array) {
        // 스트림을 이용하여 모든 문자열을 하나의 문자열로 결합하고 중복을 제거합니다.
        String distinctLetters = Arrays.stream(array)
                .flatMap(str -> Stream.of(str.split("")))
                .distinct()
                .reduce("", (a, b) -> a + b);

        // 문자열을 문자 배열로 변환하여 반환합니다.
        String[] result = distinctLetters.split("");
        Arrays.sort(result);
        return result;
    }

    // flatMap을 이용하여 String[] array 안에있는 문자에 대해 스트림한 요소를 바로 얻을 수 있다.
    // 그러므로 faltMap은 2차원 배열에서 유용하다.
}
