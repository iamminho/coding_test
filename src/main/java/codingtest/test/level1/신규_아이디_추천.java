package codingtest.test.level1;

public class 신규_아이디_추천 {
    /*
     * 1. 대문자를 모두 소문자로 치환한다.
     * 2. 알파벳 소문자, 숫자, -, _, .를 제외한 모든 문자를 제거한다.
     * 3. 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환한다.
     * */
    public static void main(String[] args) {
        String newId = "=.=";
        String result = solution(newId);
        System.out.println("result = " + result);
    }

    public static String solution(String newId) {
        newId = newId.toLowerCase();
        newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
        newId = newId.replaceAll("[.]+", ".");
        newId = newId.replaceAll("^[.]+|[.]+$", "");
        if (newId.isEmpty()) newId = "a";
        if (newId.length() >= 16) {
            newId = newId.substring(0, 15);
            newId = newId.replaceAll("[.]+$", "");
        }
        while (newId.length() < 3) {
            newId += newId.charAt(newId.length() - 1);
        }
        return newId;
    }
}
