package codingtest.test.level2;

import java.util.Stack;

public class 주식가격 {
    /*
     * stack에 들어오는 것들은 아직까지는 뒤의 숫자보다 더 작은 숫자가 없는 index이다.
     * 만약 더 작은 숫자가 들어온다면 stack에 있는 더 작은 숫자들의 답을 정해준다. answer에 기록한다.
     * 마지막까지 stack에 남아있는 index들은 뒤의 숫자보다 작은 숫자가 없는 숫자들의 index들이다.
     * */


    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 2, 3};
        int[] result = solution(prices);

        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }

        return answer;
    }
}
