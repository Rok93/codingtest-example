package p20200819;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1 {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostStds = Arrays.stream(lost)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());

        List<Integer> reserveStds = Arrays.stream(reserve)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());

        List<Integer> selfLoans = lostStds.stream()
                .filter(lostStd -> reserveStds.contains(lostStd))
                .collect(Collectors.toList());

        lostStds = lostStds.stream()
                .filter(lostStd -> !selfLoans.contains(lostStd))
                .collect(Collectors.toList());

        List<Integer> filteredReserveStds = reserveStds.stream()
                .filter(reserveStd -> !selfLoans.contains(reserveStd))
                .collect(Collectors.toList());

        int answer = n - lostStds.size();

        for (int lostStd : lostStds) {
            if (lostStd > 1) {
                if (filteredReserveStds.contains(lostStd - 1)) {
                    answer++;
                    filteredReserveStds.remove(new Integer(lostStd - 1));
                    continue;
                }
            }

            if (lostStd < filteredReserveStds.size() - 1) {
                if (filteredReserveStds.contains(lostStd + 1)) {
                    answer++;
                    filteredReserveStds.remove(new Integer(lostStd + 1));
                }
            }
        }

        return answer;
    }
}
