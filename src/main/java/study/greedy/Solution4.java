package study.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

// 그리디 문제 : 모험가 길드
public class Solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int adventurerNumber = sc.nextInt();
        List<Integer> fearValues = new ArrayList<>();
        for (int i = 0; i < adventurerNumber; i++) {
            fearValues.add(sc.nextInt());
        }

        Map<Integer, Long> numberByFearValue = fearValues.stream()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

        int answer = 0;
        for (int fearValue : numberByFearValue.keySet()) {
            if (fearValue <= numberByFearValue.get(fearValue)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
