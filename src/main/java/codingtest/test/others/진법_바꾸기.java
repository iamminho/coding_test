package codingtest.test.others;

public class 진법_바꾸기 {
    public static void main(String[] args) {
        String s = "1010";
        int v = Integer.parseInt(s, 2);
        String hex = Integer.toString(v, 16);
        System.out.println("hex = " + hex);
    }
}
