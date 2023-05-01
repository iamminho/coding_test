package codingtest.test.level1;

public class 문자열_내_p와_y의_개수 {
    /*
     * s의 모든 문자를 소문자로 치환
     * s의 모든 p문자를 ""로 치환
     * 원래 길이와 치환한 길이의 차를 구해줌
     * y문자도 위와같이 구해줌
     * 결과적으로 p와 y의 개수를 구해서 비교 -> 둘다 0, 같으면 -> true / 다르면 false
     *
     * 필요한 기능
     * 특정 문자를 ""로 치환해서 원래 길이와의 차를 구해주는 기능
     * */

    public static void main(String[] args) {
        String s = "ozdyfetf";
        System.out.println("result = " + solution(s));
    }

    private static boolean solution(String s) {
        String lowerCase = s.toLowerCase();
        int pNumber = getStrNumber("p", lowerCase);
        int yNumber = getStrNumber("y", lowerCase);

        return pNumber == yNumber;
    }

    private static int getStrNumber(String v, String s) {
        String replaced = s.replace(v, "");
        return s.length() - replaced.length();
    }


}
