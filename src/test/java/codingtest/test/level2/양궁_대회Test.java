package codingtest.test.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("양궁대회 test")
class 양궁_대회Test {
    private static 양궁_대회 test = new 양궁_대회();

    @Nested
    @DisplayName("scoreDiff 메소드")
    static class ScoreDiff {
        static Stream<Arguments> scoreDiffTestCases() {
            return Stream.of(
                    Arguments.of(new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, new int[]{0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0}, 6),
                    Arguments.of(new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0}, 29),
                    Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2}, 49)
            );
        }

        @DisplayName("scoreDiff test")
        @ParameterizedTest
        @MethodSource("scoreDiffTestCases")
        void scoreDiffTest(int[] apeach, int[] ryan, int answer) {
            int result = test.scoreDiff(apeach, ryan);
            assertThat(result).isEqualTo(answer);
        }
    }

    @Nested
    @DisplayName("isPrior 메소드")
    static class Prior {
        static Stream<Arguments> isPriorTestCases() {
            return Stream.of(
                    Arguments.of(new int[]{2, 2, 2, 2, 0, 0, 0, 2, 0, 0, 0}, new int[]{2, 2, 2, 2, 1, 0, 0, 3, 0, 0, 0}, true),
                    Arguments.of(new int[]{0, 0, 2, 3, 4, 1, 0, 0, 0, 0, 0}, new int[]{9, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, true),
                    Arguments.of(new int[]{2, 3, 1, 0, 0, 0, 0, 3, 3, 0, 0}, new int[]{2, 1, 0, 2, 0, 0, 0, 2, 3, 0, 0}, false)
            );
        }

        @DisplayName("isPrior test")
        @ParameterizedTest
        @MethodSource("isPriorTestCases")
        void scoreDiffTest(int[] apeach, int[] ryan, boolean answer) {
            boolean result = test.isPrior(apeach, ryan);
            assertThat(result).isEqualTo(answer);
        }
    }

    @Nested
    @DisplayName("Solution 메소드")
    static class Solution {
        static Stream<Arguments> solutionTestCases() {
            return Stream.of(
                    Arguments.of(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, new int[]{0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0}),
                    Arguments.of(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new int[]{-1}),
                    Arguments.of(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0}),
                    Arguments.of(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2})
            );
        }

        @DisplayName("solution test")
        @ParameterizedTest
        @MethodSource("solutionTestCases")
        void scoreDiffTest(int n, int[] info, int[] answer) {
            int[] result = test.solution(n, info);
            assertThat(result).isEqualTo(answer);
        }
    }
}
