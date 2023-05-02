package codingtest.test.level2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class 주차_요금_계산Test {
    주차_요금_계산 test = new 주차_요금_계산();

    @Test
    void test1() {
        int[] fees = new int[]{180, 5000, 10, 600};
        String[] records = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] result = test.solution(fees, records);
        int[] answer = new int[]{14600, 34400, 5000};

        assertThat(result).isEqualTo(answer);
    }

}