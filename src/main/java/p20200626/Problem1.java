package p20200626;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {

    private static List<Integer> list;
    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tryNumber = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i < tryNumber; i++) {
            list.add(sc.nextInt());
        }

        dfs(0, 0);
        System.out.println(cnt);
    }

    private static void dfs(int curIndex, int sum) {
        System.out.println(" curValue: " + list.get(curIndex) + " curIndex: " + curIndex + " sum: " + sum);
        if (sum < 0 || sum > 20) {
            return;
        }

        if (curIndex == list.size() - 2) {
            if (list.get(curIndex + 1).equals(sum)) {
                cnt++;
            }
            return;
        }

        dfs(curIndex + 1, sum + list.get(curIndex));
        dfs(curIndex + 1, sum - list.get(curIndex));
    }
}
