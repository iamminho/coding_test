package codingtest.test.level2.다리를_지나는_트럭;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 다리를_지나는_트럭_re {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> trucks = IntStream.of(truck_weights)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayDeque::new));

            Queue<Integer> bridge = Stream.generate(() -> 0)
                    .limit(bridge_length)
                    .collect(Collectors.toCollection(ArrayDeque::new));

            int answer = crossBridge(weight, trucks, bridge);

            return answer;
        }

        private int crossBridge(int weight, Queue<Integer> trucks, Queue<Integer> bridge) {
            int bridgeWeight = 0;
            int time = 0;

            while (!trucks.isEmpty()) {
                time++;

                bridgeWeight -= bridge.poll();

                if (bridgeWeight + trucks.peek() <= weight) {
                    int truck = trucks.poll();
                    bridge.add(truck);
                    bridgeWeight += truck;
                } else bridge.add(0);

            }

            while (!bridge.isEmpty()) {
                time++;
                bridge.poll();
            }

            return time;
        }
    }
}
