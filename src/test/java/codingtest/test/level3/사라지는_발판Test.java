package codingtest.test.level3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class 사라지는_발판Test {
    private static 사라지는_발판 test = new 사라지는_발판();

    @Nested
    @DisplayName("solution 메소드")
    static class Solution {
        static Stream<Arguments> cases() {
            return Stream.of(
                    Arguments.of(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[]{1, 0}, new int[]{1, 2}, 5),
                    Arguments.of(new int[][]{{1, 1, 1, 1, 1}}, new int[]{0, 0}, new int[]{0, 4}, 4),
                    Arguments.of(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}, new int[]{1, 0}, new int[]{1, 2}, 4)

            );
        }

        @DisplayName("solution test")
        @ParameterizedTest
        @MethodSource("cases")
        void solutionTest(int[][] board, int[] aloc, int[] bloc, int result) {
            int answer = test.solution(board, aloc, bloc);
            assertThat(answer).isEqualTo(result);
        }
    }
}