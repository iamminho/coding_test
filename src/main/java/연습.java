import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 연습 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        String[] stringArray = list.stream()
                .toArray(String[]::new);

        System.out.println(Arrays.toString(stringArray));
    }
}
