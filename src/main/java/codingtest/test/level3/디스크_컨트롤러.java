package codingtest.test.level3;

import java.util.*;

public class 디스크_컨트롤러 {
    public static class Work {
        int start;
        int time;

        public Work(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}};
        int answer = solution(jobs);
        System.out.println("answer = " + answer);
    }

    private static int solution(int[][] jobs) {
        Work[] works = new Work[jobs.length];

        int i = 0;
        for (int[] job : jobs) {
            works[i++] = new Work(job[0], job[1]);
        }

        Arrays.sort(works, Comparator.comparingInt(a -> a.start));

        return getResult(works);
    }

    private static int getResult(Work[] works) {
        int sum = 0;
        int time = 0;
        int size = works.length;
        Queue<Work> q = new LinkedList<>(Arrays.asList(works));
        PriorityQueue<Work> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));


        while (!q.isEmpty() || !pq.isEmpty()) {
            while (!q.isEmpty() && q.peek().start <= time) {
                pq.add(q.poll());
            }
            if (pq.isEmpty()) {
                time = q.peek().start;
                continue;
            }

            Work poll = pq.poll();
            sum += time + poll.time - poll.start;
            time += poll.time;
        }

        return sum / size;
    }
}
