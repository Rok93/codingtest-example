package p20201023.NHNTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2 {

    private static void solution(int day, int width, int[][] blocks) {
        // 매일 오전에 벽돌을 쌓고, 오후에 한번 시멘트를 붓는다
        // 시멘트가 벽돌 밖으로 흘러넘치지 않도록, 매일 최대한 양의 시멘트를 부어야 한다.
        // 부어둔 시멘트는 밤사이 굳어서 다음 날 그 위에도 벽돌을 쌓을 수 있다.

        List<Stack<Integer>> stacks = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            stacks.add(new Stack<>());
        }


        int needTotalCement = 0;
        for (int i = 0; i < day; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < blocks[i][j]; k++) {
                    stacks.get(j).add(1);
                }
            }

            for (int j = 1; j < width - 1; j++) {
                int currentHeight = stacks.get(j).size();

                int leftHeight = findLeftMaxHeight(stacks, j);
                int rightHeight = findRightMaxHeight(stacks, j);

                int fillHeight = Math.min(leftHeight, rightHeight);

                if (fillHeight > currentHeight) {
                    int needCement = fillHeight - currentHeight;
                    needTotalCement += needCement;

                    while (stacks.get(j).size() < fillHeight) {
                        stacks.get(j).add(1);
                    }
                }
            }

        }

        System.out.println(needTotalCement);

    }

    private static int findRightMaxHeight(List<Stack<Integer>> stacks, int j) {
        int maxHeight = -1;
        while (++j < stacks.size()) {
            maxHeight = Math.max(stacks.get(j).size(), maxHeight);
        }

        return maxHeight;
    }

    private static int findLeftMaxHeight(List<Stack<Integer>> stacks, int j) {
        int maxHeight = -1;
        while (--j >= 0) {
            maxHeight = Math.max(stacks.get(j).size(), maxHeight);
        }

        return maxHeight;
    }

    public static void main(String[] args) {
//        int day = 2;
//        int width = 6;
//        int[][] blocks = {{6, 2, 11, 0, 3, 5}, {6, 3, 0, 9, 0, 5}};

        int day = 3;
        int width = 10;
        int[][] blocks = {{6, 12, 0, 2, 8, 4, 0, 7, 3, 6}, {6, 1, 3, 0, 2, 8, 0, 0, 13, 8}, {6, 3, 0, 10, 6, 5, 7, 0, 0, 3}};


        solution(day, width, blocks);
    }
}
