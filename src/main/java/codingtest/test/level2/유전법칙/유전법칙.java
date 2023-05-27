package codingtest.test.level2.유전법칙;

public class 유전법칙 {
    static int[] order = new int[]{4, 1, 2, 3};

    public static String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            answer[i] = find(query[0], query[1]);
        }
        return answer;
    }

    public static String find(int generation, int number) {
        if (generation == 1) return "Rr";

        int prevN = (int) Math.ceil((double) number / 4);
        String bean = find(generation - 1, prevN);
        int curN = order[number % 4];

        return getBean(bean, curN);
    }

    public static String getBean(String bean, int curN) {
        if (bean.equals("RR")) return "RR";
        if (bean.equals("rr")) return "rr";

        String[] beans = new String[]{"RR", "Rr", "Rr", "rr"};
        return beans[curN - 1];
    }
}
