package codingtest.test.level1.외톨이_알파벳;

public class 외톨이_알파벳_정규식 {
    public String solution(String input_string) {
        String inputString = "." + input_string + ".";

        StringBuilder builder = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (inputString.split(c + "+").length < 3) {
                continue;
            }
            builder.append(c);
        }

        if (builder.length() == 0) return "N";
        return builder.toString();
    }
}
