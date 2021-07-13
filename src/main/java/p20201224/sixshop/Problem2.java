package p20201224.sixshop;

import java.util.*;
import java.util.stream.*;

public class Problem2 {
    public int[] solution(int[] grade) {
        int gradeLen = grade.length;
        List<Student> students = IntStream.range(0, gradeLen)
                .mapToObj(id -> new Student(id, grade[id]))
                .collect(Collectors.toList());

        Collections.sort(students);

        int[] answer = new int[gradeLen];
        int currentGrade = 1;
        int accumulateGrade = 0;
        int currentScore = 0;
        for (int i = 0; i < gradeLen; i++) {
            int id = students.get(i).getId();
            int score = students.get(i).getScore();

            if (i == 0) { // 최초 1등!
                answer[id] = currentGrade;
                currentScore = score;
                accumulateGrade++;
                continue;
            }

            if (score == currentScore) {
                answer[id] = currentGrade;
                accumulateGrade++;
                continue;
            }

            currentGrade += accumulateGrade;
            accumulateGrade = 1;
            answer[id] = currentGrade;
            currentScore = score;
        }

        return answer;
    }

    public class Student implements Comparable<Student>{
        private int id;
        private int score;

        public Student(int id, int score) {
            this.id = id;
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(Student o) {
            if (this.score > o.score) {
                return -1;
            }

            return 1;
        }
    }
}
