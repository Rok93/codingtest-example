package toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<Integer> inputs = Arrays.stream(input.split(" "))
                .map(Integer::new)
                .collect(Collectors.toList());

        List<Integer> distinctInputs = inputs.stream()
                .distinct()
                .collect(Collectors.toList());

        int size = distinctInputs.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            Integer key = distinctInputs.get(i);
            map.put(key, compute(key));
        }

        for (int number : inputs) {
            System.out.print(matchComputeValue(map, number) + " ");
        }
    }

    private static int matchComputeValue(Map<Integer, Integer> map, int number) {
        for (int key : map.keySet()) {
            if (key == number) {
                Integer value = map.get(new Integer(key));
                return value;
            }
        }
        return -1;
    }

    private static int compute(int n) {
        return n * 3;
    }
}
