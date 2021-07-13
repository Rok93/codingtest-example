package totay_house;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem2 {

    public int solution(int input, List<Integer> runtimesa) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> runtimes = new ArrayList<>(runtimesa);
        int totalRuntime = 0;
        while (!runtimes.isEmpty()) {
            runtimes.sort(Comparator.comparingInt(Integer::intValue));
            if (runtimes.size() >= 2) {
                runtimes.remove(0);
                System.out.println("더할녀석: " + runtimes.get(runtimes.size() - 1));
                totalRuntime += runtimes.remove(runtimes.size() - 1);
                continue;
            }

            totalRuntime += runtimes.remove(0);
        }

        return totalRuntime;
    }

}
