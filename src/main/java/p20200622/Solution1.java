package p20200622;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution1 {

    public static final int THREE = 3;
    public static final int TWO = 2;
    private static List<Long> list;
    private static long[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int size = 1;
        int cnt = 0;
        while (true) {
            if (size >= N) {
                break;
            }
            size += twoInvolution(++cnt);
        }

        System.out.println("size=" + size);
        System.out.println("cnt=" + cnt);

        arr = new long[cnt + 1];
        arr[0] = 1;
        for (int i = 1; i < cnt + 1; i++) {
            arr[i] = THREE * arr[i - 1];
        }

        list = new ArrayList<>();
        for (int i = 0; i < cnt + 1; i++) {
            addCase(i);
        }

        List<Long> answer = list.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(answer.get(N - 1));
    }

    private static void addCase(int curIndex) {
        for (int r = 1; r <= curIndex + 1; r++) {
            System.out.println("curIndex : " + curIndex + " i : " + r);
            long[] comArr = new long[r];
            combination(comArr, curIndex, r, 0, 0);
        }
    }

    //조합 (순서관심없고 뽑은 유무만 생각)
    private static void combination(long[] comArr, int n, int r, int index, int target) {
        if (r == 0) {
            long sum = 0;
            for (long number : comArr) {
                sum += number;
            }
            list.add(sum);
            return;
        }
        if (target == n + 1) return;

        comArr[index] = arr[target];
        combination(comArr, n, r - 1, index + 1, target + 1);//뽑는경우
        combination(comArr, n, r, index, target + 1);//안뽑는경우
    }

    private static int twoInvolution(int cnt) {
        if (cnt == 0) {
            return 1;
        }

        int temp = 1;
        for (int i = 0; i < cnt; i++) {
            temp *= TWO;
        }
        return temp;
    }
}
