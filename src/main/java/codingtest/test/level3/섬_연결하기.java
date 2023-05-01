package codingtest.test.level3;

import java.util.Arrays;
import java.util.Comparator;

public class 섬_연결하기 {
    public static void main(String[] args) {
        int n = 4;
        int costs[][] = new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        int answer = solution(n, costs);
        System.out.println("answer = " + answer);
    }

    public static class Node {
        private int depth = 1;
        private Node parent = null;

        public boolean isConnected(Node o) {
            return root() == o.root();
        }

        public void merge(Node o) {
            if (isConnected(o)) return;

            Node root1 = root();
            Node root2 = o.root();

            if (root1.depth > root2.depth) root2.parent = root1;
            else if (root2.depth > root1.depth) root1.parent = root2;
            else {
                root2.parent = root1;
                root1.depth += 1;
            }
        }

        private Node root() {
            if (parent == null) return this;
            return parent = parent.root();
        }
    }

    public static class Edge {
        public final int u;
        public final int v;
        public final int cost;

        private Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    private static int solution(int n, int[][] costs) {
        Edge[] edges = Arrays.stream(costs)
                .map(edge -> new Edge(edge[0], edge[1], edge[2]))
                .sorted(Comparator.comparingInt(e -> e.cost))
                .toArray(Edge[]::new);

        Node[] nodes = new Node[n];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }

        int totalCost = 0;
        for (Edge edge : edges) {
            Node node1 = nodes[edge.u];
            Node node2 = nodes[edge.v];

            if (node1.isConnected(node2)) continue;
            node1.merge(node2);
            totalCost += edge.cost;
        }

        return totalCost;
    }
}
