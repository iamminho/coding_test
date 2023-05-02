package codingtest.test.level2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class 주차_요금_계산 {
    /*public static void main(String[] args) {
        int[] fees = new int[]{180, 5000, 10, 600};
        String[] records = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
    }*/

    private static class Fee {
        private final int baseTime;
        private final int basefee;
        private final int unitTime;
        private final int unitFee;

        public Fee(int baseTime, int basefee, int unitTime, int unitFee) {
            this.baseTime = baseTime;
            this.basefee = basefee;
            this.unitTime = unitTime;
            this.unitFee = unitFee;
        }

        public int cost(int time) {
            int fee = basefee;
            time -= baseTime;

            while (time > 0) {
                fee += unitFee;
                time -= unitTime;
            }
            return fee;
        }
    }

    private static class Car {
        public final String number;
        private final Fee fee;
        public int inTime = -1;
        private int totalTime = 0;

        public Car(String number, Fee fee) {
            this.number = number;
            this.fee = fee;
        }

        public void in(int time) {
            this.inTime = time;
        }

        public void out(int time) {
            if (this.inTime == -1) return;
            totalTime += time - this.inTime;
            this.inTime = -1;
        }

        public int cost() {
            return fee.cost(totalTime);
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        Fee fee = new Fee(fees[0], fees[1], fees[2], fees[3]);
        Map<String, Car> cars = new HashMap<>();

        for (String record : records) {
            String[] tokens = record.split(" ");
            int time = parseTime(tokens[0]);
            String number = tokens[1];
            boolean isIn = tokens[2].equals("IN");

            if (!cars.containsKey(number)) {
                cars.put(number, new Car(number, fee));
            }
            Car car = cars.get(number);
            if (isIn) {
                car.in(time);
            } else {
                car.out(time);
            }

        }

        int endTime = parseTime("23:59");
        for (Car car : cars.values()) {
            car.out(endTime);
        }

        return cars.values().stream()
                .sorted(Comparator.comparing(car -> car.number))
                .mapToInt(Car::cost)
                .toArray();
    }

    private static int parseTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));
        return hour * 60 + minute;
    }
}
