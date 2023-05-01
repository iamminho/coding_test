package codingtest.test.level1;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};
        String result = solution(participant, completion);
        System.out.println("result = " + result);
    }

    private static String solution(String[] participant, String[] completion) {
        Map<String, Long> participantMap = toMap(participant);
        for (String s : completion) {
            long v = participantMap.get(s) - 1;
            participantMap.put(s, v);
            if (v == 0) participantMap.remove(s);
        }

        return participantMap.keySet().iterator().next();
    }

    private static Map<String, Long> toMap(String[] participant) {
        return Arrays.stream(participant)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ));
    }
}
