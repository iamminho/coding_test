package codingtest.test.level3;

import java.util.PriorityQueue;

public class 이중_우선순위_큐 {
    public static class DoublePriority {
        int size = 0;
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
        PriorityQueue<Integer> pqDsc = new PriorityQueue<>((a, b) -> b - a);
    }

    public static void main(String[] args) {
        String[] operations = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] result = solution(operations);
        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static int[] solution(String[] operations) {
        int[] result = new int[2];
        DoublePriority dp = new DoublePriority();

        for (String operation : operations) {
            String[] ops = operation.split(" ");
            String op = ops[0];
            int opNum = Integer.parseInt(ops[1]);

            if (op.equals("I")) {
                add(dp, opNum);
            } else {
                remove(dp, opNum);
            }
        }


        return getResult(dp);
    }

    private static void add(DoublePriority dp, int opNum) {
        dp.pqAsc.add(opNum);
        dp.pqDsc.add(opNum);
        dp.size++;
    }

    private static void remove(DoublePriority dp, int opNum) {
        if (dp.size == 0) return;
        if (dp.size - 1 == 0) {
            dp.pqAsc.clear();
            dp.pqDsc.clear();
        }
        if (opNum == 1) {
            dp.pqDsc.poll();
            dp.size--;
        } else {
            dp.pqAsc.poll();
            dp.size--;
        }
    }

    private static int[] getResult(DoublePriority dp) {
        int[] result = new int[2];

        if (dp.size == 0) return result;
        else {
            result[0] = dp.pqDsc.peek();
            result[1] = dp.pqAsc.peek();
            return result;
        }
    }
}
