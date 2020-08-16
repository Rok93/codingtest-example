package algorithm;

import java.util.Arrays;

public class MergeSort {
    static int[] buff;
    // a[left] ~ a[right]를 재귀적으로 병합 정렬
    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;

            __mergeSort(a, left, center); // 배열의 앞부분을 병합 정렬한다.
            __mergeSort(a, center + 1, right); // 배열의 뒷부분을 병합 정렬한다.

            for (i = left; i <= center; i++) {
                buff[p++] = a[i];
            }

            while(i <= right && j < p) {
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
            }

            while(j < p) {
                a[k++] = buff[j++];
            }
        }
    }

    // 병합 정렬
    static void mergeSort(int[] a, int n) {
        buff = new int[n]; // 작업용 배열을 생성

        __mergeSort(a, 0, n - 1); // 배열 전체를 병합 정렬한다.

        buff = null;
    }

    public static void main(String[] args) {
        int[] a = new int[]{10, 5, 6, 8, 2, 3, 1}; // 1, 2, 3, 5, 6, 8, 10
//        MergeSort mergeSort = new MergeSort();
        print(a);
        mergeSort(a, a.length);
        print(a);
    }

    private static void print(int[] arr) {
        Arrays.stream(arr)
                .forEach(number -> System.out.print(number + " "));
        System.out.println();
    }
}
