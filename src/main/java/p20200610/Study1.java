package p20200610;

import java.util.*;
import java.util.stream.Collectors;

public class Study1 {
    private static List<int[]> answerList;

    public static void main(String[] args) { //nPm
        //1 ~ N까지 자연수 중에서 중복 없이 M개를 고른 수열  --> 수열
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (i + 1);
        }

        answerList = new ArrayList<>();
        perm(arr, 0, N, M);
        answerList.stream()
                .sorted((o1, o2) -> {
                    int len = o1.length;
                    for (int i = 0; i < len; i++) {
                        if (o1[i] == o2[i]) {
                            continue;
                        }
                        return Integer.compare(o1[i], o2[i]);
                    }
                    return Integer.compare(o1[0], o2[0]);
                })
                .forEach(Study1::print);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
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
