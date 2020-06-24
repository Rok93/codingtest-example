package p20200617;

import java.util.Scanner;
import java.util.Stack;

public class Study3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());

        Stack<Egg> eggs = new Stack<>();
        for (int i = 0; i < cnt; i++) {
            String[] inputs = sc.nextLine().split(" "); //내구도 무
            eggs.push(new Egg(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[0])));
        }

        Egg leftEgg = eggs.pop();
        for (Egg egg : eggs) {
            Egg rightEgg = eggs.pop();

        }
    }

    public static class Egg {
        private static int weight;
        private static int strength;

        public Egg(int weight, int strength) {
            this.weight = weight;
            this.strength = strength;
        }

        public static void bumpedEggs(int eggWeight) {
            weight -= eggWeight;
        }

        public static boolean isBroken() {
            return strength < 0;
        }

        public static int getWeight() {
            return weight;
        }

        public static int getStrength() {
            return strength;
        }
    }
}
