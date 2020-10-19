package kakao2020;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KakaoProblem3 {
    public int[] solution(String[] info, String[] query) {

        List<Applicant> applicants = Arrays.stream(info)
                .map(Applicant::new)
                .collect(Collectors.toList());

        return Arrays.stream(query)
                .mapToInt(condition -> findPassPeople(condition, applicants))
                .toArray();
    }

    private int findPassPeople(String condition, List<Applicant> applicants) {
        String[] conditions = Arrays.stream(condition.split(" "))
                .map(String::trim)
                .filter(letter -> !letter.equals("and"))
                .toArray(String[]::new);

        String wantedLanguage = conditions[0];
        String wantedPosition = conditions[1];
        String wantedCareer = conditions[2];
        String wantedSoulFood = conditions[3];
        int wantedScore = Integer.parseInt(conditions[4]);

        Collections.sort(applicants);

        return (int) applicants.stream()
                .filter(applicant -> applicant.isEqualToLanguage(wantedLanguage))
                .filter(applicant -> applicant.isEqualToPosition(wantedPosition))
                .filter(applicant -> applicant.isEqualToCareer(wantedCareer))
                .filter(applicant -> applicant.isEqualToSoulFood(wantedSoulFood))
                .filter(applicant -> applicant.isSatisfiedScore(wantedScore))
                .count();

    }

    public class Applicant implements Comparable<Applicant> {
        private final String language;
        private final String position;
        private final String career;
        private final String soulFood;
        private final int score;

        public Applicant(String info) {
            String[] infos = info.split(" ");
            this.language = infos[0];
            this.position = infos[1];
            this.career = infos[2];
            this.soulFood = infos[3];
            this.score = Integer.parseInt(infos[4]);
        }

        public Applicant(String language, String position, String career, String soulFood, int score) {
            this.language = language;
            this.position = position;
            this.career = career;
            this.soulFood = soulFood;
            this.score = score;
        }

        public boolean isEqualToLanguage(String wantedLanguage) {
            if (wantedLanguage.equals("-")) {
                return true;
            }

            return language.equals(wantedLanguage);
        }

        public boolean isEqualToPosition(String wantedPosition) {
            if (wantedPosition.equals("-")) {
                return true;
            }

            return position.equals(wantedPosition);
        }

        public boolean isEqualToCareer(String wantedCareer) {
            if (wantedCareer.equals("-")) {
                return true;
            }

            return career.equals(wantedCareer);
        }

        public boolean isEqualToSoulFood(String wantedSoulFood) {
            if (wantedSoulFood.equals("-")) {
                return true;
            }

            return soulFood.equals(wantedSoulFood);
        }

        public boolean isSatisfiedScore(int wantedScore) {
            return score >= wantedScore;
        }

        public String getLanguage() {
            return language;
        }

        public String getPosition() {
            return position;
        }

        public String getCareer() {
            return career;
        }

        public String getSoulFood() {
            return soulFood;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(Applicant o) { // 성적 오름차순
            if (score < o.score) {
                return -1;
            }

            return 1;
        }
    }
}
