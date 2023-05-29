package codingtest.test.level3.길_찾기_게임;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 길_찾기_게임_re {
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

        int[][] result = solution(nodeInfo);
        Arrays.stream(result)
                .forEach(v -> {
                    System.out.println(Arrays.toString(v));
                });
    }

    private static class Node {
        int x;
        int y;
        int idx;

        Node left = null;
        Node right = null;

        public Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    private static int[][] solution(int[][] nodeInfo) {
        int[][] result = new int[2][];
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeInfo.length; i++) {
            nodes.add(new Node(nodeInfo[i][0], nodeInfo[i][1], i + 1));
        }

        Collections.sort(nodes, (a, b) -> {
            if (b.y == a.y) {
                return a.x - b.x;
            }
            return b.y - a.y;
        });

        Construct(nodes);
        result[0] = preorder(nodes);
        result[1] = postorder(nodes);

        return result;
    }

    private static Node Construct(List<Node> nodes) {
        Node root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            insert(root, nodes.get(i));
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

    private static int[] preorder(List<Node> nodes) {
        List<Integer> result = new ArrayList<>();
        preorder(nodes.get(0), result);
        return result.stream()
                .mapToInt(n -> n)
                .toArray();
    }


    private static void preorder(Node node, List<Integer> result) {
        result.add(node.idx);
        if (node.left != null) preorder(node.left, result);
        if (node.right != null) preorder(node.right, result);
    }

    private static int[] postorder(List<Node> nodes) {
        List<Integer> result = new ArrayList<>();
        postorder(nodes.get(0), result);
        return result.stream()
                .mapToInt(n -> n)
                .toArray();
    }

    private static void postorder(Node node, List<Integer> result) {
        if (node.left != null) postorder(node.left, result);
        if (node.right != null) postorder(node.right, result);
        result.add(node.idx);
    }
}


//for (int i = 0; i < nodes.size(); i++) {
//        Node node = nodes.get(i);
//        Node left;
//        Node right;
//
//        if (node.left != null) {
//        left = node.left;
//        } else left = null;
//
//        if (node.right != null) {
//        right = node.right;
//        } else right = null;
//
//        System.out.println("idx: " + node.idx);
//        System.out.println("x: " + node.x);
//        System.out.println("y: " + node.y);
//
//        if (left != null) {
//        System.out.println("left idx: " + left.idx);
//        System.out.println("left x: " + left.x);
//        System.out.println("left y: " + left.y);
//        }
//
//        if (right != null) {
//        System.out.println("right idx: " + right.idx);
//        System.out.println("right x: " + right.x);
//        System.out.println("right y: " + right.y);
//        }
//
//        System.out.println();
//        }
