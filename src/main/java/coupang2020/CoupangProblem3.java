package coupang2020;

import java.util.*;
import java.util.stream.Collectors;

public class CoupangProblem3 {

    private List<Integer> scores;
    private int[] differenceValues;
    private Set<Integer> forgedScoreIndexes;

    public int solution(int k, int[] score) {
        // 인접된 등수 사이의 점수차가 k번이상 반복되어 나온다면, 해당하는 인접된 등수는 모두 조작된 점수이다!

        // 이 때, 조작되지 않은 점수는 몇 개인지 구하려 한다.

        // 조작의 기준인 반복 횟수 k
        // 내림차순으로 정렬된 점수가 담긴 배열 score
        // 조작되지 않은 점수가 하나도 없다면 0을 return

        scores = Arrays.stream(score)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());

        int scoreLen = scores.size();
        differenceValues = new int[scoreLen - 1];

        for (int i = 0; i < scoreLen - 1; i++) {
            differenceValues[i] = score[i] - score[i + 1];
        }

        List<Map.Entry<Integer, Long>> list = removeForgedScores(k);
        forgedScoreIndexes = new HashSet<>();
        list.stream()
                .forEach(entry -> removeForgedScore(entry.getKey()));

        forgedScoreIndexes.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(index -> scores.remove(index.intValue()));

        return scores.size();
    }

    private void removeForgedScore(int differenceValue) {
        System.out.println("차이값: " + differenceValue);
        int len = differenceValues.length;
        for (int i = 0; i < len; i++) {
            if (differenceValues[i] == differenceValue) {
                forgedScoreIndexes.add(i + 1);
                forgedScoreIndexes.add(i);
            }
        }
    }

    private List<Map.Entry<Integer, Long>> removeForgedScores(int k) {
        int scoreLen = scores.size();
        int[] differenceValues = new int[scoreLen - 1];

        for (int i = 0; i < scoreLen - 1; i++) {
            differenceValues[i] = scores.get(i) - scores.get(i + 1);
        }

        return Arrays.stream(differenceValues)
                .mapToObj(Integer::new)
                .collect(Collectors.groupingBy(Integer::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > k - 1)
                .collect(Collectors.toList());
    }
}
