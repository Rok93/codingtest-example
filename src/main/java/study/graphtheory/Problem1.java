package study.graphtheory;

import java.util.Scanner;

// p.298: 팀 결성
public class Problem1 {
    private static final String YES = "YES";
    private static final String NO = "NO";
    private static int[] parent;

    private static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        parent = new int[N + 1];

        int M = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(); // 0이면 합친다, 1이면 같은 팀에 속해 있는지를 확인하는 연산.
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == 1) {
                System.out.println(findParent(b) == findParent(c) ? YES : NO);
                continue;
            }

            unionParent(b, c);
        }


    }
}
