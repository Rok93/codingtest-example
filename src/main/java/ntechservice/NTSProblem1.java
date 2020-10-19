package ntechservice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class NTSProblem1 {
    public int solution(int[][] flowers) {
        Set bloomDays = new HashSet();
        Arrays.stream(flowers)
                .forEach(duration -> addBloomDay(duration, bloomDays));

        return bloomDays.size();
    }

    private void addBloomDay(int[] duration, Set<Integer> bloomDays) {
        IntStream.range(duration[0], duration[1])
                .forEach(bloomDay -> bloomDays.add(bloomDay)); // 지는날은 제외한다!
    }
}
