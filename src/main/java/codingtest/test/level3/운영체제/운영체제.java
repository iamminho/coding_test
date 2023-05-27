package codingtest.test.level3.운영체제;

import java.util.*;
import java.util.stream.Collectors;

public class 운영체제 {
    public static void main(String[] args) {

    }

    private static class Program {
        public final int priority;
        public final int calledAt;
        public final int executionTime;

        public Program(int priority, int calledAt, int executionTime) {
            this.priority = priority;
            this.calledAt = calledAt;
            this.executionTime = executionTime;
        }
    }

    private static long[] solution(int[][] program) {
        Queue<Program> programs = Arrays.stream(program)
                .map(p -> new Program(p[0], p[1], p[2]))
                .sorted(Comparator.comparing(p -> p.calledAt))
                .collect(Collectors.toCollection(LinkedList::new));

        PriorityQueue<Program> pq = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) {
                return a.priority - b.priority;
            }
            return a.calledAt - b.calledAt;
        });

        long[] waitTimes = new long[11];
        int time = 0;
        while (!programs.isEmpty() || !pq.isEmpty()) {
            while (!programs.isEmpty() && time >= programs.peek().calledAt) {
                pq.add(programs.poll());
            }

            if (pq.isEmpty()) {
                time = programs.peek().calledAt;
                continue;
            }

            Program p = pq.poll();
            waitTimes[p.priority] += time - p.calledAt;
            time += p.executionTime;
        }
        waitTimes[0] = time;

        return waitTimes;
    }
}