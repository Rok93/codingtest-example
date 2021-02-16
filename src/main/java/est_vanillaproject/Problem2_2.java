package est_vanillaproject;

import java.util.*;

public class Problem2_2 {

    private int minValue = Integer.MAX_VALUE;
    private int scoresLength;
    private int[][] graph;

    public int solution(int[] scores, int k) { //dfs로 푸는 것은 아마도 의도한 방식이 아닐 것이라 추측한다!
        scoresLength = scores.length;
        graph = new int[scoresLength][scoresLength];

        List<Group> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> subList = new ArrayList<>();
            for (int j = (scoresLength / k) * i; j < (scoresLength / k) * (i + 1); j++) {
                subList.add(scores[cnt++]);
            }
            list.add(new Group(i, subList));
        }

        System.out.println(list);

        while (true) {

            int sum = list.stream()
                    .mapToInt(Group::getSub)
                    .sum();

            Group group = list.stream()
                    .max(Comparator.comparing(Group::getSub))
                    .get();

            int maxTeam = group.getTeam();
            if (maxTeam > k) {
                Group otherGroup = list.get(maxTeam - 1);

                group.moveBeforeTeam(otherGroup);
            }

            if (maxTeam == 0) {
                Group otherGroup = list.get(1);

                group.moveNextTeam(otherGroup);
            }

            System.out.println(list);


            minValue = minValue > sum ? sum : minValue;

//            System.out.println(minValue);

            if (3 < 0) {
                break;
            }
        }


        return minValue;
    }

    public class Group {
        private int team;
        private List<Integer> list;

        public Group(int team, List<Integer> list) {
            this.team = team;
            this.list = list;
        }

        public int getSub() {
            return list.get(list.size() - 1) - list.get(0);
        }

        public int getTeam() {
            return team;
        }

        public void moveBeforeTeam(Group beforeGroup) {
            beforeGroup.add(list.get(0));
            list.remove(0);
        }

        private void add(Integer student) {
            list.add(student);
        }

        public void moveNextTeam(Group nextGroup) {
            nextGroup.addFirst(list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }

        private void addFirst(Integer lastStudent) {
            list.add(0, lastStudent);
        }

        @Override
        public String toString() {
            return "Group{" +
                    "team=" + team +
                    ", list=" + list +
                    '}';
        }
    }
}
