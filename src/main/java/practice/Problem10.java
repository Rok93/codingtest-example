package practice;

import java.util.Arrays;

public class Problem10 {
    public int[] solution(int m, int n, int[][] picture) {

//        Map<Integer, List<Integer>> map = Arrays.stream(picture)
//                .flatMapToInt(Arrays::stream)
//                .boxed()
//                .collect(Collectors.groupingBy(number -> number));

        int numberOfArea = (int) Arrays.stream(picture)
                .flatMapToInt(Arrays::stream)
                .distinct()
                .count();
        int maxSizeOfOneArea = 0;
//        int maxSizeOfOneArea = map.entrySet().stream()
//                .max()
//                .getAsInt();

        System.out.println(numberOfArea);


        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    public static void main(String[] args) {
        Problem10 sol = new Problem10();
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        int[] answer = sol.solution(m, n, picture);
    }
}
