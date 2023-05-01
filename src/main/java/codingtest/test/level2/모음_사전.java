package codingtest.test.level2;

import java.util.ArrayList;
import java.util.List;

public class 모음_사전 {
    private static final char[] CHARS = "AEIOU".toCharArray();

    public static void main(String[] args) {
        String word = "EIO";
        List<String> dic = generate("");
        int wordNum = dic.indexOf(word);
        System.out.println("wordNum = " + wordNum);
    }

    private static List<String> generate(String word) {

        List<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5) return words;

        for (char c : CHARS) {
            words.addAll(generate(word + c));
        }
        return words;
    }
}
