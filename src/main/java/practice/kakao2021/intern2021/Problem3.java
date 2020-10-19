package practice.kakao2021.intern2021;

import java.util.Arrays;

//효율성 실패!
public class Problem3 {
    public int[] solution(String[] gems) {
        int kindOfGemsNumber = (int) Arrays.stream(gems)
                .distinct()
                .count();

        //최소 범위는 kindOfGemsNumber 가 되야한다!
        int len = gems.length;
        int lange = kindOfGemsNumber;
        while (lange < len) {
            for (int i = 0; i < len - kindOfGemsNumber; i++) {
                String[] temp = Arrays.copyOfRange(gems, i, i + lange);
                int numberOfTypeGem = (int) Arrays.stream(temp)
                        .distinct()
                        .count();

                if (numberOfTypeGem == kindOfGemsNumber) {
                    return new int[]{i + 1, i + lange};
                }
            }
            lange++;
        }
        return new int[]{1, gems.length};
    }
}
