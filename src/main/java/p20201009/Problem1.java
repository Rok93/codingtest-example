package p20201009;

import java.awt.*;
import java.util.Arrays;

public class Problem1 {
    public static void main(String[] args) {
        Point point = new Point(1, 2);
        System.out.println(point.getX());
        System.out.println(point.getY());

        int[] a = new int[200];
        Arrays.fill(a, 0);

        System.out.println(Arrays.toString(a));
    }
}
