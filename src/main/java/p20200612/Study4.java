package p20200612;

import java.util.*;

public class Study4 {
    public static void main(String[] args) {
        // i번째 마을  위치 : X[i], 사람 : A[i]   거리의 합이 합이 소가 되는 위치에 우체국 세우기!
        Scanner sc = new Scanner(System.in);
        int tryNumber = Integer.parseInt(sc.next());
        int[] X = new int[tryNumber + 1];
        int[] A = new int[tryNumber + 1];

        Map<Integer, Integer> xbyA = new HashMap<>();
        for (int i = 1; i <= tryNumber; i++) {
            X[i] = Integer.parseInt(sc.next());
            A[i] = Integer.parseInt(sc.next());

            xbyA.put(X[i], A[i]);
        }
        //우체국 거리는 마을의 위치 min ~ max 사이에 있어야 함
        int distanceMin = Arrays.stream(X)
                .min()
                .getAsInt();

        int distanceMax = Arrays.stream(X)
                .max()
                .getAsInt();

        Map<Integer, Integer> answers = new HashMap<>();

        for (int i = distanceMin; i < distanceMax; i++) {

        }

//        answers.keySet().stream()
//                .filter(key -> answers.get(key).equals(min))
//                .forEach(System.out::println);
    }
}
