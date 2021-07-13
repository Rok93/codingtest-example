package divider;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderFactory {
    private static final List<String> MEMBERS = Arrays.asList("워니", "마갸", "마크" ,"바다", "삭정", "샐리", "아론",
            "우기","제리", "제이온", "케빈", "파피", "피카");

    public static void main(String[] args) {
        List<String> distinctMembers = MEMBERS.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("**********************************");
        int membersNumber = distinctMembers.size();
        System.out.printf("사회자(=로키)를 제외한 총인원은 %d명 입니다. \n" , membersNumber);

        System.out.println((int) (1 + Math.random() * 12));

//        for (int round = 1; round <= 3 ; round++) {
//            playRound(round, membersNumber);
//        }
    }

    private static void playRound(int round, int membersNumber) {
        Collections.shuffle(MEMBERS);
        System.out.print(round + "라운드 순서:  ");
        String firstResult = IntStream.range(0, membersNumber)
                .mapToObj(sequence -> "[" + (sequence + 1) + "]" + MEMBERS.get(sequence))
                .collect(Collectors.joining(" "));

        System.out.println(firstResult);
    }
}
