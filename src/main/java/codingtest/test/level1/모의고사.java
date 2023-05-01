package codingtest.test.level1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    /*
     * 패턴과, 답을 넣어 점수를 구해주는 기능을 구현
     * 각 수포자의 점수를 구함
     * 수포자의 점수를 비교하여 제일 높은 점수를 result에 담음
     * result를 오름차순 정렬
     */
    private static final int[][] RULES = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    /*
     * {3, 1, 2, 4, 5, 2, 4, 2, 1, 3, 2}
     * {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1}  2
     * {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2}  3
     * {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3}  3
     * */

    public static void main(String[] args) {
        int[] answer = {3, 1, 2, 4, 5, 2, 4, 2, 1, 3, 2};
        List<Integer> result = solution(answer);
        System.out.println("result = " + result);
    }

    private static List<Integer> solution(int[] answer) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < RULES.length; i++) {
            int count = getPoint(RULES[i], answer);
            result.add(count);
        }

        return getWinner(result);
    }

    private static int getPoint(int[] person, int[] answer) {
        int count = 0;
        int lenP = person.length;
        for (int i = 0; i < answer.length; i++) {
            int idxP = i % lenP;
            if (answer[i] == person[idxP]) count++;
        }
        return count;
    }

    private static List<Integer> getWinner(List<Integer> result) {
        List<Integer> list = new ArrayList<>();
        int max = result.stream()
                .mapToInt(x -> x)
                .max()
                .getAsInt();


        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == max) list.add(i + 1);
        }

        return list;
    }


}
