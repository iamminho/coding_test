package codingtest.test.level2;

import java.util.Stack;

public class 타겟넘버_2 {
    private static class State {
        public final int index;
        public final int acc;

        public State(int index, int acc) {
            this.index = index;
            this.acc = acc;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{4, 1, 2, 1};
        int target = 4;
        int answer = solution(numbers, target);
        System.out.println(answer);
    }

    private static int solution(int[] numbers, int target) {
        Stack<State> stack = new Stack<>();
        stack.add(new State(0, 0));

        int count = 0;
        while (!stack.isEmpty()) {
            State state = stack.pop();

            if (state.index == numbers.length) {
                if (state.acc == target) count++;
                continue;
            }

            stack.push(new State(state.index + 1, state.acc + numbers[state.index]));
            stack.push(new State(state.index + 1, state.acc - numbers[state.index]));
        }

        return count;
    }
}
