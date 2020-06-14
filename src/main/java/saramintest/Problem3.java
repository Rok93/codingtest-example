package saramintest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNum = Integer.parseInt(br.readLine());

        CustomStack stack = new CustomStack();
        while (tryNum > 0) {
            tryNum--;
            String inputOrder = br.readLine(); // 0 푸쉬(stack overflow), 1 팝(underflow) 고려!
            if (inputOrder.equals("0")) {
                int pushNum = Integer.parseInt(br.readLine());
                //푸쉬
                stack.push(pushNum);
                continue;
            }
            if (inputOrder.equals("1")) {
                stack.pop();
                continue;
            }
            break; //0, 1 이외의 숫자 프로그램 종료
        }

        if (stack.isEmpty()) { // stack의 size가 0이라면 그냥 종료 아니라면
            return;
        }
        stack.print();
    }

    public static class CustomStack {
        private static final int SIZE = 10;
        private static final int[] arr = new int[SIZE];

        private static int currentPoint = 0;

        public static void push(int number) {
            if (currentPoint >= SIZE) {
                System.out.println("overflow");
                return;
            }
            arr[currentPoint++] = number;
        }

        public static void pop() { //원래 마지막 값이 반환 되야하는데 여기서 요구사항은 꼭 그러지 않아도 된다.
            if (currentPoint == 0) {
                System.out.println("underflow");
                return;
            }
            currentPoint--;
        }

        public static boolean isEmpty() {
            return currentPoint == 0;
        }

        public static void print() {
            Arrays.stream(arr)
                    .filter(num -> num != 0)
                    .forEach(num -> System.out.print(num + " "));
        }
    }
}
