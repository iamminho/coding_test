package codingtest.test.level2;


import java.util.Arrays;

/*
 * n권의 논문중 h편 이상의 논문이 h번 이상 인용되어야 한다.
 * 반대로 나머지 논문이 h번 이하 인용되어야한다.
 *
 * 1. 오름차순으로 배열을 정렬한다. -> 0, 1, 3, 5, 6
 * 2. 배열길이 len 부터 시작해 1까지 검사한다. -> h
 *      h가 만약 5라면 배열[0]이 5보다 커야한다.
 *      (len - h) >= h ?
 *
 * 이 문제는 나머지 논문이 h번 이하 인용되어야 한다는 조건이 무시(?)된거 같다?
 * */
public class H_index {

    public static void main(String[] args) {
        int[] citations = {1, 4, 4, 5, 8};
        int result = solution(citations);
        System.out.println("result = " + result);
    }

    private static int solution(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for (int h = len; h >= 1; h--) {
            if (isValid(citations, h)) {
                return h;
            }
        }
        return 0;
    }

    private static boolean isValid(int[] citations, int h) {
        int idx = citations.length - h;
        return citations[idx] >= h;
    }
}
