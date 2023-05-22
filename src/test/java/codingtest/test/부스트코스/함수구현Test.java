package codingtest.test.부스트코스;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class 함수구현Test {
    private static 함수구현 test = new 함수구현();

    @Nested
    @DisplayName("overlap 메소드")
    static class Overlap {
        static Stream<Arguments> overlapCases() {
            return Stream.of(
                    Arguments.of(new int[]{1, 2, 3, 3, 3, 3, 4, 4}, new int[]{4, 2}),
                    Arguments.of(new int[]{3, 2, 4, 4, 2, 5, 2, 5, 5}, new int[]{3, 2, 3}),
                    Arguments.of(new int[]{3, 5, 7, 9, 1}, new int[]{-1})
            );
        }

        @DisplayName("overlap test")
        @ParameterizedTest
        @MethodSource("overlapCases")
        void overlapTest(int[] arr, int[] answer) {
            int[] result = test.overlap(arr);
            assertThat(result).isEqualTo(answer);
        }
    }
}