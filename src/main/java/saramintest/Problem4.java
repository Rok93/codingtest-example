package saramintest;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem4 {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        String[] input = SC.nextLine().split(" ");
        int N = Integer.parseInt(input[0]); // 이 조건을 왜 준걸까?
        int Q = Integer.parseInt(input[1]);
        String bookInitials = SC.nextLine();

        for (int i = 0; i < Q; i++) {
            String[] sectionInputs = SC.nextLine().split(" ");
            int L = Integer.parseInt(sectionInputs[0]);
            int R = Integer.parseInt(sectionInputs[1]);

            String partBookIntials = bookInitials.substring(L - 1, R);
            String[] splitPartInitials = partBookIntials.split("");
            Map<String, Long> countByInitial = Arrays.stream(splitPartInitials)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Long maxNum = countByInitial.values()
                    .stream()
                    .mapToLong(Long::longValue)
                    .max()
                    .getAsLong();

            // 해당 구간에서 책 제목의 첫 글자로 가장 많이 등장한 알파벳을 출력한다
            // 등장 횟수가 같은 알파벳이 여러개라면 사전순으로 가장 앞서는 알파벳을 출력한다.
            String answer = countByInitial.keySet()
                    .stream()
                    .filter(key -> countByInitial.get(key).equals(maxNum))
                    .sorted()
                    .findFirst()
                    .get();
            System.out.println(answer);
        }
    }
}
