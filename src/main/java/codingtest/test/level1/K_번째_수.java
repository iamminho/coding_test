package codingtest.test.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class K_번째_수 {
    /*
     * commands
     * 1. commands 의 [0],[1]만큼 subString 한다.
     * 2. subString한 값을 정렬한다.
     * 3. 정렬한 값중 commands[2]의 값을 출력한다.
     * */


    public static void main(String[] args) {
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        Set<String> result = list.stream()
                .map(i -> i.toString())
                .collect(Collectors.toSet());
        System.out.println(result);


        List<Integer> results = solution(commands, array);
        System.out.println("results = " + results);


    }

    private static List<Integer> solution(int[][] commands, int[] array) {
        List<Integer> results = new ArrayList<>();
        for (int[] command : commands) {
            results.add(command(command, array));
        }
        return results;
    }

    private static int command(int[] cmd, int[] array) {
        int from = cmd[0] - 1;
        int to = cmd[1];
        int k = cmd[2] - 1;
        int[] destArray = Arrays.copyOfRange(array, from, to);
        Arrays.sort(destArray);
        return destArray[k];
    }
}


