package p20200913;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (answer.isEmpty()) {
                answer.add(arr[i]);
                continue;
            }

            if (answer.get(answer.size() - 1).equals(arr[i])) {
                continue;
            }

            answer.add(arr[i]);
        }

        System.out.println(answer);
    }
}
