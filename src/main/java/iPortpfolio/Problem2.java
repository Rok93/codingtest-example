package iPortpfolio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public boolean solution(int[] arrA, int[] arrB) {
        String a = getString(arrA);
        a += a;

        String b = getString(arrB);

        return a.contains(b);
    }

    private String getString(int[] arrB) {
        String b = "";

        List<String> bList = Arrays.stream(arrB)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
        for (String s : bList) {
            if (s.length() == 1) {
                b += s;
                continue;
            }
            b += "'" + s + "'";
        }
        return b;
    }
}
