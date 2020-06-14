package saramintest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem11 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNumber = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < tryNumber; i++) {
            list.add(Integer.parseInt(inputs[i]));
        }

        list = list.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> answerList = new ArrayList<>();
        answerList.add(list.get(0));
        list.remove(0);
        while (answerList.size() < tryNumber) {
            int answerLastNumber = answerList.get(answerList.size() - 1);
            int number = list.stream()
                    .mapToInt(Integer::intValue)
                    .filter(num -> answerLastNumber != num)
                    .min()
                    .getAsInt();

            list.remove(new Integer(number));
            answerList.add(number);
        }

        System.out.println(calculatePurchaseDesire(answerList));
    }

    private static int calculatePurchaseDesire(List<Integer> list) {
        int len = list.size();
        int beforeMark = list.get(0);
        int cnt = 0;
        for (int i = 1; i < len; i++) {
            int curMark = list.get(i);
            if (curMark > beforeMark) {
                cnt++;
            }
            beforeMark = curMark;
        }
        return cnt;
    }
}
