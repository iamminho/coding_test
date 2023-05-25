package codingtest.test.level1.외톨이_알파벳;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class 외톨이_알파벳_2 {
    class Solution {
        public String solution(String input_string) {
            String last = "";
            List<String> strings = new ArrayList<>();
            Set<String> answer = new HashSet<>();

            for (String s : input_string.split("")) {
                if (!last.equals(s)) {
                    if (strings.contains(s)) answer.add(s);
                    else strings.add(s);
                    last = s;
                }
            }

            if (answer.isEmpty()) return "N";

            return answer.stream()
                    .sorted()
                    .collect(Collectors.joining());
        }
    }
}
