package codingtest.test.level2.순위_검색;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class 순위검색_re {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> scoreMap = buildScoreMap(info);

        return Stream.of(query)
                .mapToInt(q -> count(q, scoreMap))
                .toArray();
    }

    private Map<String, List<Integer>> buildScoreMap(String[] info) {
        Map<String, List<Integer>> scoreMap = new HashMap<>();
        for (String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            forEachKey(0, "", tokens, key -> {
                scoreMap.putIfAbsent(key, new ArrayList<>());
                scoreMap.get(key).add(score);
            });
        }

        for (List<Integer> list : scoreMap.values()) {
            Collections.sort(list);
        }

        return scoreMap;
    }

    private void forEachKey(int index, String prefix, String[] tokens,
                            Consumer<String> action) {
        if (index == tokens.length - 1) {
            action.accept(prefix);
            return;
        }

        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);
    }

    private int count(String query, Map<String, List<Integer>> scoreMap) {
        String[] tokens = query.split(" (and )?");
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

        if (!scoreMap.containsKey(key)) return 0;
        List<Integer> scores = scoreMap.get(key);
        int score = Integer.parseInt(tokens[tokens.length - 1]);

        return scores.size() - binarySearch(score, scoreMap.get(key));
    }

    private int binarySearch(int score, List<Integer> scores) {
        int start = 0;
        int end = scores.size() - 1;

        while (end > start) {
            int mid = start + end;
            if (score <= scores.get(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (scores.get(start) < score) {
            return scores.size();
        }
        return start;
    }
}
