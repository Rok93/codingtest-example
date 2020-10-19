package study.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// p. 180 정렬 : 성적이 낮은 순서로 학생 출력하기
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentNumber = sc.nextInt();
        sc.nextLine();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentNumber; i++) {
            String input = sc.nextLine();
            String[] infos = input.split(" ");
            students.add(new Student(infos[0], Integer.parseInt(infos[1])));
        }

        String answer = students.stream()
                .sorted()
                .map(Student::getName)
                .collect(Collectors.joining(" "));

        System.out.println(answer);
    }

    static class Student implements Comparable<Student> {
        private final String name;
        private final int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Student other) {
            return this.score - other.score;
        }
    }
}
