package codingtest.test.level2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class 메뉴_리뉴얼_2 {
    private static class Course {
        public final String course;
        public final int occurrences;

        public Course(String course, int occurrences) {
            this.course = course;
            this.occurrences = occurrences;
        }
    }

    public static void main(String[] args) {
        String a = "acvnb";
        String[] orders = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] courses = new int[]{2, 3, 4};
        List<Set<String>> orderList = Arrays.stream(orders)
                .map(String::chars)
                .map(charStream -> charStream
                        .mapToObj(menu -> String.valueOf((char) menu))
                        .collect(Collectors.toSet()))
                .collect(Collectors.toList());
        System.out.println("orderList = " + orderList);
    }

    private static void getCourse(char nextMenu, Set<String> selectedMenu, List<Set<String>> orderList,
                                  Map<Integer, List<Course>> courses) {
        int occurrences = (int) orderList.stream()
                .filter(order -> selectedMenu.containsAll(order))
                .count();

        if (occurrences < 2) return;
        int size = selectedMenu.size();

        if (courses.containsKey(size)) {
            List<Course> courseList = courses.get(size);
            String courseTmp = selectedMenu.stream()
                    .sorted()
                    .collect(Collectors.joining(""));
            Course course = new Course(courseTmp, occurrences);
            Course original = courseList.get(0);

            if (original.occurrences < occurrences) {
                courseList.clear();
                courseList.add(course);
            } else if (original.occurrences == occurrences) {
                courseList.add(course);
            }
        }

    }
}
