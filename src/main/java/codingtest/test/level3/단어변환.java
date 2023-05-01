package codingtest.test.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    public static class State {
        String word;
        int step;

        public State(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        int answer = solution(begin, target, words);
        System.out.println("answer = " + answer);
    }

    public static int solution(String begin, String target, String[] words) {
        return find(begin, target, words);
    }

    private static int find(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<State> que = new LinkedList<>();
        que.add(new State(begin, 0));


        while (!que.isEmpty()) {
            State state = que.poll();

            if (state.word.equals(target)) {
                return state.step;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i] || !isConvertable(state.word, words[i])) continue;

                que.add(new State(words[i], state.step + 1));
                visited[i] = true;
            }
        }

        return 0;
    }

    private static boolean isConvertable(String begin, String word) {
        int diff = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) diff++;
        }

        return diff == 1;
    }
}
