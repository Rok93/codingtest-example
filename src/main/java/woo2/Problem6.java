package woo2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {
    public String[] solution(String[][] forms) {
        int formsLength = forms.length;
        List<Crew> crews = IntStream.range(0, formsLength)
                .mapToObj(index -> new Crew(forms[index][0], forms[index][1]))
                .collect(Collectors.toList());

        Set<Crew> answer = new HashSet<>();
        int crewsSize = crews.size();
        for (int i = 0; i < crewsSize - 1; i++) {
            Crew beforeCrew = crews.get(i);
            for (int j = i + 1; j < crewsSize; j++) {
                Crew afterCrew = crews.get(j);
                if (beforeCrew.isSimilar(afterCrew)) {
                    answer.add(beforeCrew);
                    answer.add(afterCrew);
                }
            }
        }

        return answer.stream()
                .map(Crew::getEmail)
                .sorted(Comparator.naturalOrder())
                .toArray(String[]::new);
    }

    public class Crew implements Comparable<Crew> {
        public static final int SUBSTRING_NUMBER = 2;

        private final String email;
        private final String nickName;

        public Crew(String email, String nickName) {
            this.email = email;
            this.nickName = nickName;
        }

        public String getEmail() {
            return email;
        }

        public String getNickName() {
            return nickName;
        }

        public boolean isSimilar(Crew crew) {
            int crewNickNameLength = nickName.length();
            String crewNickName = crew.getNickName();
            for (int i = 0; i < crewNickNameLength - 1; i++) {
                String subNickName = nickName.substring(i, i + SUBSTRING_NUMBER);
                if (crewNickName.contains(subNickName)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int compareTo(Crew o) {
            return extractInt(email) - extractInt(o.email);
        }

        int extractInt(String s) {
            String num = s.replaceAll("\\D", "");
            System.out.println(num);
            // return 0 if no digits found
            return num.isEmpty() ? 0 : Integer.parseInt(num);
        }
    }
}
