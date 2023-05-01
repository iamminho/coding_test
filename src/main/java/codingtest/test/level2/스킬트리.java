package codingtest.test.level2;

import java.util.Arrays;

public class 스킬트리 {
    public static void main(String[] args) {
        String[] skillTree = new String[]{"BACDE", "CBADF", "AECB", "BDA"};
        String skill = "CBD";
        int answer = solution(skillTree, skill);
        System.out.println(answer);
    }

    private static int solution(String[] skillTree, String skill) {
        return (int) Arrays.stream(skillTree)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(skill::startsWith)
                .count();
    }
}

