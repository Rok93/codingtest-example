package p20200622;

import java.util.Scanner;

public class Solution2 {

    public static final int SIX_GUITAR_LINE_PACKAGE = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        int N = Integer.parseInt(inputs[0]); // 끊어진 기타줄 갯수
        int M = Integer.parseInt(inputs[1]); //기타줄 브랜드

        int answer = 1000 * 100 + 1;
        int needSetNum = (int) Math.ceil((double) N / SIX_GUITAR_LINE_PACKAGE);
        int setPrice = 6001;
        int eachPrice = 1001;
        for (int i = 0; i < M; i++) {
            String[] temp = sc.nextLine().split(" ");
            int packagePrice = Integer.parseInt(temp[0]);
            int onePrice = Integer.parseInt(temp[1]);

            setPrice = packagePrice < setPrice ? packagePrice : setPrice;
            eachPrice = onePrice < eachPrice ? onePrice : eachPrice;

        }
        int setSum = setPrice * needSetNum;
        int eachSum = eachPrice * N;
        int mixSum = (setPrice * (N / SIX_GUITAR_LINE_PACKAGE) + (eachPrice * (N % SIX_GUITAR_LINE_PACKAGE)));
        int minPrice = setSum > eachSum ? eachSum : setSum > mixSum ? mixSum : setSum;
        System.out.println(minPrice < answer ? minPrice : answer);
    }
}
