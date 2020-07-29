package p20200522;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Study3 {
    public static void main(String[] args) {
        List<Integer> cVolumes = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] volumes = input.split(" ");
        int a = Integer.parseInt(volumes[0]);
        int b = Integer.parseInt(volumes[1]);
        int c = Integer.parseInt(volumes[2]); //처음 가득 차있음

        cVolumes.add(c); //용량 그대로
        cVolumes.add(c - b); //용량 그대로
        cVolumes.add(c - a); //용량 그대로
        cVolumes.add(a); //용량 그대로
        cVolumes.add(b); //용량 그대로

        String s = cVolumes.stream()
                .distinct()
                .sorted(Comparator.comparing(Integer::intValue))
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(s);
    }
}
