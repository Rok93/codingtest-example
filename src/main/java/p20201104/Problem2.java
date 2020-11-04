package p20201104;

import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 상근이의 동기수 ( 2 <= n < 500)
        int m = sc.nextInt(); // 리스트의 길이 m (1 <= m <= 10,000)

        Map<Integer, User> list = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            list.put(i, new User(i));
        }

        for (int i = 0; i < m; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();

            list.get(i1).addFriend(i2);
            list.get(i2).addFriend(i1);
        }

        Set<Integer> answer = new HashSet<>();

        User targetUser = list.get(1);
        List<Integer> targetFriends = targetUser.getFriends();
        for (int friend : targetFriends) {
            answer.add(friend);
        }

        for (int friend : targetFriends) {
            List<Integer> friends = list.get(friend).getFriends();
            for (int friendFriend : friends) {
                answer.add(friendFriend);
            }
        }

        answer.remove(new Integer(1));

        System.out.println(answer.size());
    }

    public static class User {
        private final int number;
        private List<Integer> friends;

        public User(int number) {
            this.number = number;
            friends = new ArrayList<>();
        }

        public void addFriend(int friendNumber) {
            friends.add(friendNumber);
        }

        public List<Integer> getFriends() {
            return friends;
        }
    }
}
