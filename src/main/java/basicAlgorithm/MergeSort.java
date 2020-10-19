package basicAlgorithm;

import java.util.Arrays;

public class MergeSort {
    private static int[] src;
    private static int[] tmp;

    public static void main(String[] args) {
        src = new int[]{1, 9, 8, 5, 4, 2, 3, 7, 6};
        tmp = new int[src.length];
        printArray(src);
        mergeSort(0, src.length - 1);
        printArray(tmp);
    }

    private static void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        int p = start;
        int q = mid + 1;
        int idx = p;

        while (p <= mid || q <= end) {
            if (q > end || (p <= mid && src[p] < src[q])) {
                tmp[idx++] = src[p++];
                continue;
            }
            tmp[idx++] = src[q++];
        }

        for (int i = start; i <= end; i++) {
            src[i] = tmp[i];
        }
    }

    private static void printArray(int[] src) {
        Arrays.stream(src)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
}
