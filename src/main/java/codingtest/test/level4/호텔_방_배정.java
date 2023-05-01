package codingtest.test.level4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 호텔_방_배정 {
    public static void main(String[] args) {
        int k = 10;
        long[] room_number = new long[]{1, 3, 4, 1, 3, 1};
        long[] answer = solution(k, room_number);
        for (long value : answer) {
            System.out.print(value + " ");
        }
        System.out.println("");
    }

    private static class Node {
        private int depth = 1;
        private Node parent = null;
        private long max;

        public Node(long value) {
            max = value;
        }

        public boolean isConnected(Node o) {
            return root() == o.root();
        }

        public long max() {
            return root().max;
        }

        public void merge(Node o) {
            if (isConnected(o)) return;

            Node root1 = root();
            Node root2 = o.root();

            if (root1.depth > root2.depth) {
                root2.parent = root1;
            } else if (root2.depth > root1.depth) {
                root1.parent = root2;
            } else {
                root2.parent = root1;
                root1.depth++;
            }

            root1.max = root2.max = Math.max(root1.max, root2.max);
        }

        public Node root() {
            if (parent == null) return this;
            return parent.root();
        }
    }

    public static long[] solution(long k, long[] room_number) {
        List<Long> assigned = new ArrayList<>();

        Map<Long, Node> nodes = new HashMap<>();
        for (long num : room_number) {
            if (nodes.containsKey(num)) {
                num = nodes.get(num).max() + 1;
            }

            Node node = new Node(num);
            nodes.put(num, node);
            if (nodes.containsKey(num - 1)) {
                node.merge(nodes.get(num - 1));
            }
            if (nodes.containsKey(num + 1)) {
                node.merge(nodes.get(num + 1));
            }

            assigned.add(num);
        }

        return assigned.stream().mapToLong(Long::longValue).toArray();
    }
}
