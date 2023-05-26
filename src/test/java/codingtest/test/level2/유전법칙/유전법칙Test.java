package codingtest.test.level2.유전법칙;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class 유전법칙Test {
    private static 유전법칙 test = new 유전법칙();

    @Nested
    @DisplayName("solution 메소드")
    static class Solution {
        static Stream<Arguments> solutionTestCases() {
            return Stream.of(
                    Arguments.of(new int[][]{{3, 5}}, new String[]{"RR"}),
                    Arguments.of(new int[][]{{3, 8}, {2, 2}}, new String[]{"rr", "Rr"}),
                    Arguments.of(new int[][]{{3, 1}, {2, 3}, {3, 9}}, new String[]{"RR", "Rr", "RR"}),
                    Arguments.of(new int[][]{{4, 26}}, new String[]{"Rr"})
            );
        }

        @DisplayName("solution test")
        @ParameterizedTest
        @MethodSource("solutionTestCases")
        void solutionTest(int[][] queries, String[] answer) {
            String[] result = test.solution(queries);
            assertThat(result).isEqualTo(answer);
        }
    }
}