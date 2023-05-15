package codingtest.test.level2.모음_사전;

import java.util.ArrayList;
import java.util.List;

public class 모음_사전_re {
    class Solution {
        private final String[] letters = {"A", "E", "I", "O", "U"};
        private boolean flag = false;

        public int solution(String word) {
            List<String> words = new ArrayList<>();
            search(word, "", words);
            return words.size() - 1;
        }

        private void search(String word, String myWord, List<String> words) {
            words.add(myWord);

            if (myWord.equals(word)) {
                flag = true;
            }

            if (flag) return;

            if (myWord.length() == 5) {
                return;
            }

            for (int i = 0; i < letters.length; i++) {
                if (!flag) search(word, myWord + letters[i], words);
            }
        }
    }
}
