package toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Problem4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<String> inputs = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());

        List<String> list = new ArrayList<>();

        int inputSize = inputs.size();

        for (int i = 0; i < inputSize; i++) {
            String currentValue = inputs.get(i);

            if (!list.contains(currentValue)) {
                if (list.size() <= 5) {
                    list.add(currentValue);
                    printQueue(list);
                    continue;
                }
                list.add(currentValue);
                printQueue(list);
                continue;
            }
            if (list.size() > 1) {
                list.remove(currentValue);
                list.add(currentValue);
            }
            printQueue(list);
        }
    }

    private static void printQueue(List<String> stack) {
        List<String> list = new ArrayList<>(stack);
        int lastIndex = list.size() - 1;
        int firstIndex = lastIndex - 4 >= 0 ? lastIndex - 4 : 0;
        for (int i = lastIndex; i >= firstIndex; i--) {
            if (i == firstIndex) {
                System.out.print(list.get(i));
                break;
            }
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
