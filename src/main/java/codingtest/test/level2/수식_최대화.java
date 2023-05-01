package codingtest.test.level2;//package questions.level2;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class 수식_최대화 {
//    private static final String[][] signs = {
//            "+-*".split(""),
//            "+*-".split(""),
//            "*-+".split(""),
//            "*+-".split(""),
//            "-*+".split(""),
//            "-+*".split("")
//    };
//
//    public static void main(String[] args) {
//        String expression = "100-200*300-500+20";
//        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
//        List<String> tokens = new ArrayList<>();
//        while (tokenizer.hasMoreTokens()) {
//            tokens.add(tokenizer.nextToken());
//        }
//
//        long max = 0;
//        for (String[] sign : signs) {
//            long result = calculate(sign, tokens);
//            if (max < result) max = result;
//        }
//    }
//
//    private static long calculate(String[] sign, List<String> tokens) {
//        List<String> copy = deepCopy(tokens);
//        for (String s : sign) {
//            for (int i = 0; i < copy.size(); i++) {
//                if (copy.get(i).equals(s)) {
//                    long left = Integer.parseInt(copy.get(i - 1));
//                    long right = Integer.parseInt(copy.get(i + 1));
//                    long tmp = calculate(left, right, s);
//                    copy.remove(i - 1);
//                    copy.remove(i - 1);
//                    copy.remove(i - 1);
//                    copy.add(i - 1, Long.toString(tmp));
//                    i -= 2;
//                }
//            }
//        }
//        return Math.abs(Long.parseLong(copy.get(0)));
//    }
//
//    private static long calculate(long left, long right, String s) {
//        if (s.equals("+")) return left + right;
//        if (s.equals("-")) return left - right;
//        if (s.equals("*")) return left * right;
//        return 0;
//    }
//
//    private static List<String> deepCopy(List<String> list) {
//        List<String> cp = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            cp.add(list.get(i));
//        }
//        return cp;
//    }
//
//    private long calculate(List<String> tokens, String[] precedence) {
//        for (String op : precedence) {
//            for (int i = 0; i < tokens.size(); i++) {
//                if (tokens.get(i).equals(op)) {
//                    long lhs = Long.parseLong(tokens.get(i - 1));
//                    long rhs = Long.parseLong(tokens.get(i + 1));
//                    long result = calculate(lhs, rhs, op);
//                    tokens.remove(i - 1);
//                    tokens.remove(i - 1);
//                    tokens.remove(i - 1);
//                    tokens.add(i - 1, String.valueOf(result));
//                    i -= 2;
//                }
//            }
//        }
//        return Long.parseLong(tokens.get(0));
//    }
//}
