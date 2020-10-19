package p20201015;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = IntStream.rangeClosed(2, N)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());

        int count = 0;
        while (true) {
            Integer firstNumber = list.get(0);

            int cnt = 1;
            int currentNumber = firstNumber * cnt;
            while (currentNumber <= N) {
                if (list.contains(currentNumber)) {
                    list.remove(new Integer(currentNumber));
                    count++;
                }

                if (count == K) {
                    System.out.println(currentNumber);
                    return;
                }

                currentNumber = firstNumber * (++cnt);
            }
        }
    }
}
