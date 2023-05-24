package codingtest.test.level2.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public static void main(String[] args) {
        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeight = new int[]{7, 4, 5, 6};
        int result = solution(bridgeLength, weight, truckWeight);
        System.out.println("result = " + result);

    }

    private static int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridgeLength; i++) {
            bridge.add(0);
        }

        int idx = 0;
        int curWeight = 0;
        int time = 0;

        while (idx < truckWeights.length) {
            time++;
            int poll = bridge.poll();
            if (poll > 0) curWeight -= poll;

            if (curWeight + truckWeights[idx] <= weight) {
                curWeight += truckWeights[idx];
                bridge.add(truckWeights[idx]);
                idx++;
            } else {
                bridge.add(0);
            }
        }

        while (curWeight > 0) {
            curWeight -= bridge.poll();
            time++;
        }

        return time;
    }
}
