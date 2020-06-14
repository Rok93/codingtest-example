package saramintest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {
    private static List<int[]> answerList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNumber = Integer.parseInt(br.readLine());
        int[] list = new int[tryNumber];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < tryNumber; i++) {
            list[i] = Integer.parseInt(inputs[i]);
        }

        answerList = new ArrayList<>();
        perm(list, 0, tryNumber, tryNumber); //순열

        int answer = answerList.stream()
                .mapToInt(Problem1::calculatePurchaseDesire)
                .max()
                .getAsInt();
        System.out.println(answer);

    }

    private static int calculatePurchaseDesire(int[] arr) {
        int len = arr.length;
        int beforeMark = arr[0];
        int cnt = 0;
        for (int i = 1; i < len; i++) {
            int curMark = arr[i];
            if (curMark > beforeMark) {
                cnt++;
            }
            beforeMark = curMark;
        }
        return cnt;
    }

    private static void perm(int[] arr, int depth, int n, int k) {
        if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            save(arr, k);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void save(int[] arr, int k) {
        int[] cloneArr = Arrays.copyOfRange(arr, 0, k);
        answerList.add(cloneArr);
    }
}
