package wootech2nd20201101;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 { //todo: 7번 풀기!
    public String[] solution(String user, String[][] friends, String[] visitors) {
        Map<String, User> users = new HashMap<>();
        for (String[] friend : friends) {
            User user1 = new User(friend[0]);
            User user2 = new User(friend[1]);

            if (!users.containsKey(friend[0])) {
                user1.addFriend(friend[1]);
                users.put(friend[0], user1);
            } else {
                users.get(friend[0]).addFriend(friend[1]);
            }

            if (!users.containsKey(friend[1])) {
                user2.addFriend(friend[0]);
                users.put(friend[1], user2);
            } else {
                users.get(friend[1]).addFriend(friend[0]);
            }
        }

        for (String visitor : visitors) {
            if (!users.containsKey(visitor)) {
                users.put(visitor, new User(visitor));
            }

            users.get(visitor).plusVisitedPoint();
        }

        User targetUser = users.get(user);
        users.remove(user);
        users = users.entrySet().stream()
                .filter(entry -> !targetUser.isAlreadyFriend(entry.getKey()))
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

        users.entrySet().stream()
                .map(Map.Entry::getValue)
                .forEach(d -> d.addFriendPoint(targetUser));

        return users.entrySet().stream()
                .map(Map.Entry::getValue)
                .sorted((user1, user2) -> user2.getPoint() - user1.getPoint())
                .limit(5)
                .map(User::getName)
                .sorted()
                .toArray(String[]::new);
    }

    public class User {
        private final String name;
        private List<String> friends;
        private int point;

        public User(String name) {
            this.name = name;
            friends = new ArrayList<>();
            point = 0;
        }

        public void addFriend(String friend) {
            friends.add(friend);
        }

        public void addFriendPoint(User targetUser) {
            if (friends.isEmpty()) {
                return;
            }

            List<String> targetFriends = targetUser.friends;
            targetFriends.stream()
                    .filter(friend -> targetFriends.contains(friend))
                    .forEach((friend) -> plusDuplicatedFriendPoint());
        }

        public boolean isAlreadyFriend(String friendName) {
            return friends.contains(friendName);
        }

        public String getName() {
            return name;
        }

        public int getPoint() {
            return point;
        }

        public void plusVisitedPoint() {
            point += 1;
        }

        private void plusDuplicatedFriendPoint() {
            point += 10;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, friends);
        }
    }
}
