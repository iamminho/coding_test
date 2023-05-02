package codingtest.test.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class k진수에서_소수_개수_구하기Test {
    private k진수에서_소수_개수_구하기 test = new k진수에서_소수_개수_구하기();

    @Test
    void test1() {
        int n = 437674;
        int k = 3;
        int result = test.solution(n, k);
        int answer = 3;

        Assertions.assertThat(result).isEqualTo(answer);
    }

    @Test
    void test2() {
        int n = 110011;
        int k = 10;
        int result = test.solution(n, k);
        int answer = 2;

        Assertions.assertThat(result).isEqualTo(answer);
    }
}