package kakao2020;

import java.util.*;
import java.util.stream.Collectors;

public class KakaoProblem2 {
    private List<String> courses;
    private Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) { // 2 <= orders 길이 <= 20 ,  2 <= course 길이 <= 10
        courses = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }

        for (int courseNum : course) {
            int length = orders.length;
            for (int i = 0; i < length; i++) {
                if (orders[i].length() < courseNum) {
                    continue;
                }

                dfs(orders[i], courseNum, 0, ""); // 혹시 몰라서 남겨둠
            }
        }

        Map<String, Long> collect = courses.stream()
                .collect(Collectors.groupingBy(String::new, Collectors.counting()));


        List<String> answer = new ArrayList<>();

        for (int courseNum : course) {
            long maxValue = collect.entrySet().stream()
                    .filter(entry -> entry.getKey().length() == courseNum)
                    .mapToLong(Map.Entry::getValue)
                    .max()
                    .orElse(0L);

            if (maxValue < 2) {
                continue;
            }

            collect.entrySet().stream()
                    .filter(entry -> entry.getKey().length() == courseNum)
                    .filter(entry -> entry.getValue().equals(maxValue))
                    .forEach(entry -> answer.add(entry.getKey()));
        }

        return answer.stream()
                .sorted()
                .toArray(String[]::new);
    }


    private void dfs(String order, int length, int index, String str) {
        if (index >= order.length()) {
            if (str.length() == length) {
                courses.add(str);
            }

            return;
        }

        if (length == str.length()) {
            courses.add(str);
            return;
        }

        dfs(order, length, index + 1, str.concat(String.valueOf(order.charAt(index))));
        dfs(order, length, index + 1, str);
    }
}
