package practice.kakao2021.intern;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {

    public int[] solution(String s) {
        String transS = s.substring(1, s.length() - 1);
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.stream(arr)
                .forEach(a -> System.out.print(a + " "));
        System.out.println();

        String[] sss = transS.split("},");

        List<String> list = Arrays.stream(arr)
//                .map(n -> n.replaceAll("\\{", ""))
//                .map(n -> n.replaceAll("\\}", ""))
                .sorted((Comparator.comparingInt(String::length)))
                .collect(Collectors.toList());

        /*
        sorted 안부분!!
        변화 단계 1)
        new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.length() - o2.length();
                    }
                }

        변화 단계 2)
        ((o1,o2) -> o1.length - o2.length)

        변화 단계 3) ******
        (Comparator.comparingInt(String::length))
         */

        List<Integer> answer = new ArrayList<>();

        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            String temp = list.get(i);

            int[] numbers = Arrays.stream(temp.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int i1 : numbers) {
                if (!answer.contains(i1)) {
                    answer.add(i1);
                    break;
                }
            }
        }

        return answer.stream()
                .mapToInt(Integer::new)
                .toArray();
    }

    public int[] solution2(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b) -> {
            return a.length() - b.length();
        });
        int[] answer = new int[arr.length];
        int idx = 0;
        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if (set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}
