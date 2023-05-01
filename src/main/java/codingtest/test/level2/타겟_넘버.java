package codingtest.test.level2;

public class 타겟_넘버 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        int answer = solution(numbers, target);
        System.out.println(answer);
    }

    private static int solution(int[] numbers, int target) {
        return dfs(0, numbers, target, 0);
    }

    private static int dfs(int l, int[] numbers, int target, int sum) {
        if (l == numbers.length) {
            if (sum == target) return 1;
            return 0;
        }

        return dfs(l + 1, numbers, target, sum + numbers[l]) + dfs(l + 1, numbers, target, sum - numbers[l]);
    }
}
