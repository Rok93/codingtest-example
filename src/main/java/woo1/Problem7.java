package woo1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public String solution(String cryptogram) {
        List<String> collect = Arrays.stream(cryptogram.split(""))
                .collect(Collectors.toList());

        int initialLength;
        do {
            initialLength = collect.size();
            for (int i = 0; i < collect.size() - 1; i++) {
                if (collect.get(i).equals(collect.get(i + 1))) {
                    collect.remove(i);
                    collect.remove(i);
                }
            }
        } while ((collect.size() != initialLength));

        return collect.stream()
                .collect(Collectors.joining());
    }
}
