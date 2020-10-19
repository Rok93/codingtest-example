package p20200828;

import java.util.Arrays;

public class Problem1 {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
                .mapToInt(command -> getKthNumber(array, command))
                .toArray();
    }

    private int getKthNumber(int[] array, int[] command) {
        int i = command[0];
        int j = command[1];
        int k = command[2];
        int[] subArray = Arrays.copyOfRange(array, i - 1, j);
        Arrays.sort(subArray);
        return subArray[k - 1];
    }
}
