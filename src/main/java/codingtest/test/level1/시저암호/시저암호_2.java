package codingtest.test.level1.시저암호;

public class 시저암호_2 {
    class Solution {
        public String solution(String s, int n) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char target = s.charAt(i);

                if (Character.isLetter(target)) {
                    sb.append((char) getAscii(target, n));
                } else sb.append(target);
            }
            return sb.toString();
        }

        private int getAscii(char target, int n) {
            if (Character.isUpperCase(target)) {
                return (target - 'A' + n) % 26 + 'A';
            } else {
                return (target - 'a' + n) % 26 + 'a';
            }
        }
    }
}
