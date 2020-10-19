package p20201013;

import java.util.*;

public class Problem2 {
    // 1316번
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int wordNumber = 0;
        sc.nextLine();
        for (int i = 0; i < number; i++) {
            String word = sc.nextLine();

            char[] chars = word.toCharArray();
            List<Character> list = new ArrayList<>();
            list.add(chars[0]);
            boolean notDuplication = true;
            for (int j = 1; j < word.length(); j++) {
                if (list.get(list.size() - 1).equals(chars[j])) {
                    continue;
                }

                if (list.contains(chars[j])) {
                    list.remove(new Character(chars[j]));
                    notDuplication = false;
                    break;
                }
                list.add(chars[j]);
            }

            if (notDuplication) {
                wordNumber++;
            }
        }

        System.out.println(wordNumber);
    }
}
