package n20200605;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Study1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        if (N == 1) {
            System.out.println(sc.nextLine());
            System.out.println(0);
            return;
        }

        String[][] arr = new String[N][];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine().split("");
        }

        String answerDNA = "";
        int hammingDistance = 0;


        for (int i = 0; i < M; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < N; j++) {
                if (map.containsKey(arr[j][i])) {
                    map.put(arr[j][i], map.get(arr[j][i]) + 1);
                    continue;
                }
                map.put(arr[j][i], 1);
            }
            int maxValue = map.values().stream()
                    .mapToInt(Integer::intValue)
                    .max()
                    .getAsInt();

            hammingDistance += N - maxValue;

            String temp = "";
            for (String key : map.keySet()) {
                if (map.get(key).equals(maxValue) && temp.isEmpty()) {
                    temp = key;
                    continue;
                }

                if (temp.compareTo(key) > 0) { //temp 가 key보다 사전순으로 더 뒤일 때,
                    temp = key;
                }
            }

            answerDNA += temp;
        }
        System.out.println(answerDNA);
        System.out.println(hammingDistance);
    }
}
