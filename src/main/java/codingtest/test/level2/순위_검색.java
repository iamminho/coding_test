package codingtest.test.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 순위_검색 {
    /*
     * info를 공백 기준으로 나눈다. java / backend / junior / pizza / 150 으로 나눈다.
     * query를 and 기준으로 나눈다. java / backend / junior / pizza / 100
     * [0] 부터 [3]까지 비교한다.
     * [4]는 크기의 대소를 비교한다.
     *
     * */
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        Arrays.sort(info);
        List result = new LinkedList<>();

        for (String q : query) {
            int count = 0;
            String tmp = q.replaceAll("\\s*(-|and)", "");
            String requirement = tmp.replaceAll("\\d+", "");
            requirement = requirement.replaceAll("^\\s*", "");
            int score = Integer.parseInt(tmp.replaceAll("\\D+", ""));
            for (String i : info) {
                if (i.contains(requirement)) {
                    int i_score = Integer.parseInt(i.replaceAll("\\D+", ""));
                    if (score <= i_score) {
                        count++;
                    }
                }
            }
            result.add(count);
        }

        System.out.println("result = " + result);
    }
}
