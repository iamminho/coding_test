package codingtest.test.level1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class 신고_결과_받기Test {
    신고_결과_받기 test = new 신고_결과_받기();

    @Test
    void test1() {
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] result = test.solution(id_list, report, k);
        int[] answer = new int[]{2,1,1,0};

        assertThat(result).isEqualTo(answer);

    }

    @Test
    void test2() {
        String[] id_list = new String[]{"con", "ryan"};
        String[] report = new String[]{"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        int[] result = test.solution(id_list, report, k);
        int[] answer = new int[]{0, 0};

        assertThat(result).isEqualTo(answer);

    }

}