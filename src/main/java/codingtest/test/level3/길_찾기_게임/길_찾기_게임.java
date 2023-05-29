package codingtest.test.level3.길_찾기_게임;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 길_찾기_게임 {
    public static class Node {
        public final int value;
        public final int x;
        public final int y;

        public Node left;
        public Node right;

        private Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] nodeInfo = new int[][]{
                {5, 3},
                {11, 5},
                {13, 3},
                {3, 5},
                {6, 1},
                {1, 3},
                {8, 6},
                {7, 2},
                {2, 2}
        };

        solution(nodeInfo);
    }

    private static void solution(int[][] nodeInfo) {
        Node[] nodes = new Node[nodeInfo.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1, nodeInfo[i][0], nodeInfo[i][1]);
        }
        Arrays.sort(nodes, (a, b) -> b.y - a.y);

        constructTree(nodes);
        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();

        pre(nodes[0], preList);
        post(nodes[0], postList);

        System.out.println("preList = " + preList);
        System.out.println("postList = " + postList);
    }

    private static Node constructTree(Node[] nodes) {
        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }

        return root;
    }

    private static void insert(Node root, Node node) {
        if (node.x < root.x) {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }

    private static void pre(Node node, List<Integer> visits) {
        if (node == null) return;
        visits.add(node.value);
        pre(node.left, visits);
        pre(node.right, visits);
    }

    private static void post(Node node, List<Integer> visits) {
        if (node == null) return;
        post(node.left, visits);
        post(node.right, visits);
        visits.add(node.value);
    }
}
