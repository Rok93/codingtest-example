package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem7 {
    public int[] solution(int n) {

        List<int[]> answerList = new ArrayList<>();

        answerList.add(new int[]{0});
        answerList.add(new int[]{0, 0, 1});
        answerList.add(new int[]{0, 0, 1, 0, 0, 1, 1});


        for (int i = 3; i < n; i++) {
            int[] temp = new int[getSize(i + 1)];

            getNextArray(answerList, i, temp);
            answerList.add(temp);
        }

//        answerList.forEach(array -> {
//            printArray(array);
//            System.out.println();
//        } );

        return answerList.get(n - 1);
    }

    private void getNextArray(List<int[]> answerList, int i, int[] temp) {
        int cnt = 0;
        int[] beforeArray = answerList.get(i - 1);
        for (int j = 0; j < beforeArray.length; j++) {
            temp[cnt++] = beforeArray[j];
        }
        temp[cnt++] = 0;
        for (int j = beforeArray.length - 1; j >= 0; j--) {
            temp[cnt++] = reverseNumber(beforeArray[j]);
        }
    }

    private int reverseNumber(int number) {
        if (number == 0) {
            return 1;
        }

        if (number == 1) {
            return 0;
        }

        return -1;
    }

    public void printArray(int[] array) {
        Arrays.stream(array)
                .forEach(System.out::print);
    }

    private int getSize(int n) {
        int temp = 1;
        for (int i = 0; i < n; i++) {
            temp *= 2;
        }
        return temp - 1; //2^n-1
    }

    public static void main(String[] args) {
        Problem7 sol = new Problem7();
        int n1 = 4;
        int n2 = 5;
        int n3 = 6;

        int[] answer1 = sol.solution(n1);
//        int[] answer2 = sol.solution(n2);
//        int[] answer3 = sol.solution(n3);
    }
}
