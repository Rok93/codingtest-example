import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AAA {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student(1, "경록"), new Student(2, "재홍"));

        List<Integer> collect = students.stream()
                .mapToInt(Student::getNo)
                .mapToObj(number -> number * 2)
                .collect(Collectors.toList());

    }

    public static class Student {
        private final int no;
        private final String name;

        public Student(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public String getName() {
            return name;
        }
    }
}
