package p20200617;

import java.util.*;
import java.util.stream.Collectors;

public class Study2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nationNum = Integer.parseInt(sc.nextLine());
        String[] inputs = sc.nextLine().split(" ");
        int budgetAmount = Integer.parseInt(sc.nextLine());

        List<Integer> list = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        Map<Integer, Integer> map = new HashMap<>();
        int min = list.get(nationNum - 1);
        int max = list.get(0);

        for (int i = max; i >= min; i--) {
            int limitBudget = i;
            int sum = list.stream()
                    .mapToInt((num) -> limitBudget > num ? num : limitBudget)
                    .sum();
            if (sum > budgetAmount) {
                continue;
            }
            map.put(i, sum);
        }

        int maxValue = map.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();

        int maxValueLimit = map.keySet().stream()
                .mapToInt(Integer::intValue)
                .filter(key -> map.get(key).equals(maxValue))
                .findFirst()
                .getAsInt();
        System.out.println(maxValueLimit);
    }
}
