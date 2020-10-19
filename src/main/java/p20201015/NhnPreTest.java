package p20201015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class NhnPreTest {

    private static int N;
    private static int[][] visited;
    private static int[][] board;
    private static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        visited = new int[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int inputValue = sc.nextInt();
                board[i][j] = inputValue;
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] != 0 || board[i][j] == 0) {
                    continue;
                }

                cnt++;
                dfs(i, j, cnt);
            }
        }

        System.out.println(cnt);
        IntStream.rangeClosed(1, cnt)
                .mapToObj(NhnPreTest::countNumber)
                .sorted()
                .forEach(number -> System.out.print(number + " "));
    }

    private static int countNumber(int number) {
        return (int) Arrays.stream(visited)
                .flatMapToInt(arr -> Arrays.stream(arr)
                .filter(num -> num == number))
                .count();
    }

    private static void dfs(int i, int j, int cnt) {
        if (i < 0 || i >= N || j < 0 || j >= N) {
            return;
        }

        if (board[i][j] == 0 || visited[i][j] != 0) {
            return;
        }

        visited[i][j] = cnt;
        dfs(i + 1, j, cnt);
        dfs(i, j + 1, cnt);
        dfs(i + 1, j + 1, cnt);
    }
}
