package codingtest.test.others;

import java.util.List;

public class 전위순회 {
    public static class Node {
        int data;
        Node parent;
        List<Node> children;
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.data = 1;
        pre(node);

    }


    static void pre(Node node) {
        if (node == null) return;

        System.out.println(node.data);
    }
}
