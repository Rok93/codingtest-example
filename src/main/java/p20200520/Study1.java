package p20200520;

import java.util.Scanner;

public class Study1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] a = new char[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                swapColumn(a, i, j);
                int temp = check(a);
                swapColumn(a, i, j);

                swapRow(a, i, j);
                int temp2 = check(a);
                swapRow(a, i, j);
                int max = Math.max(temp, temp2);

                if (ans < max) {
                    ans = max;
                }
            }
        }
        System.out.println(ans);
    }

    private static void swapColumn(char[][] a, int i, int j) {
        char t = a[i][j];
        a[i][j] = a[i][j + 1];
        a[i][j + 1] = t;
    }

    private static void swapRow(char[][] a, int i, int j) {
        char t = a[i][j];
        a[i][j] = a[i + 1][j];
        a[i + 1][j] = t;
    }


    static int check(char[][] a) {
        int n = a.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (a[i][j] == a[i][j - 1]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt)
                    ans = cnt;
            }
            cnt = 1;
            for (int j = 1; j < n; j++) {
                if (a[j][i] == a[j - 1][i]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt)
                    ans = cnt;
            }
        }
        return ans;
    }
}
