package codingtest.test.level3;

import java.util.HashSet;
import java.util.Set;

public class 양과_늑대 {
    public static void main(String[] args) {
        int[] info = new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = new int[][]{
                {0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}
        };

        solution(info, edges);
    }

    public static int solution(int[] info, int[][] edges) {
        boolean[][] tree = new boolean[info.length][info.length];
        for (int[] edge : edges) {
            tree[edge[0]][edge[1]] = true;
        }

        Set<Integer> nodes = new HashSet<>();
        nodes.add(0);

        return getMaxSheep(nodes, 0, 0, info, tree);
    }

    private static int getMaxSheep(Set<Integer> nodes, int sheep, int wolf, int[] info, boolean[][] tree) {
        int maxSheep = sheep;

        for (int node : nodes) {
            int nextSheep = sheep;
            int nextWolf = wolf;

            if (info[node] == 0) {
                nextSheep += 1;
            } else {
                nextWolf += 1;
            }


            if (nextWolf >= nextSheep) continue;

            Set<Integer> newNodes = getNextNodes(node, nodes, tree);
            System.out.println("node: " + node + " sheep: " + nextSheep + " wolf: " + nextWolf);
            System.out.println("newNodes = " + newNodes);
            System.out.println("---------------");

            int s = getMaxSheep(newNodes, nextSheep, nextWolf, info, tree);
            if (s > maxSheep) maxSheep = s;
        }

        return maxSheep;
    }

    private static Set<Integer> getNextNodes(int node, Set<Integer> nodes, boolean[][] tree) {
        Set<Integer> nextNodes = new HashSet<>(nodes);
        nextNodes.remove(node);

        //다음 노드 추가
        for (int next = 0; next < tree[node].length; next++) {
            if (!tree[node][next]) continue;
            nextNodes.add(next);
        }

        return nextNodes;
    }
}
