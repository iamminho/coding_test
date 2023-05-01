package codingtest.test.others;

import java.util.Arrays;

public class Arrays_copy_of {
    public static void main(String[] args) {
        String[] tokens = {"a", "b", "c"};
        String key = String.join("", Arrays.copyOf(tokens, tokens.length));
        System.out.println("key = " + key);
        for (String token : tokens) {
            System.out.print(token + " ");
        }
    }


}
