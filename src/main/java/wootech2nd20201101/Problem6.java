package wootech2nd20201101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public String[] solution(String[][] forms) {
        List<User> users = Arrays.stream(forms)
                .map(User::new)
                .collect(Collectors.toList());

        int size = users.size();
        List<User> duplicatedUsers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }

                if (isDuplicated(users.get(i), users.get(j))) {
                    duplicatedUsers.add(users.get(i));
                    break;
                }
            }
        }

        return duplicatedUsers.stream()
                .sorted()
                .map(User::getEmail)
                .toArray(String[]::new);
    }

    private boolean isDuplicated(User targetUser, User anotherUser) {
        String nickName = targetUser.getNickName();
        String anotherNickName = anotherUser.getNickName();
        int length = nickName.length();
        for (int i = 0; i < length - 1; i++) {
            String subNickName = nickName.substring(i, i + 2);

            if (anotherNickName.contains(subNickName)) {
                return true;
            }
        }

        return false;
    }


    public class User implements Comparable<User> {
        private final String email;
        private final String nickName;

        public User(String[] form) {
            this.email = form[0];
            this.nickName = form[1];
        }

        public String getEmail() {
            return email;
        }

        public String getNickName() {
            return nickName;
        }

        @Override
        public int compareTo(User o) {
            System.out.println("email: " + email);
            System.out.println("otherEmail: " + o.email);
            String otherEmail = o.email;

            String s = email.replaceAll("\\d", "");
            String s1 = otherEmail.replaceAll("\\d", "");
            System.out.println("s:" + s);
            System.out.println("s1:" + s1);
            int strCompare = s.compareTo(s1);
            System.out.println("strCompare:" + strCompare);

            if (strCompare != 0) {
                return strCompare;
            }

            String d = email.replaceAll("\\D", "");
            String d1 = otherEmail.replaceAll("\\D", "");
            System.out.println("d:" + d);
            System.out.println("d1:" + d1);
            return d.compareTo(d1);

//            if (nickName.contains(o.nickName) || o.nickName.contains(nickName)) {
//                return nickName.length() < o.nickName.length() ? -1 : 1;
//            }
//
//            return 0;
        }
    }
}
