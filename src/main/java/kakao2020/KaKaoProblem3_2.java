package kakao2020;

import java.util.Arrays;

public class KaKaoProblem3_2 {
    public int[] solution(String[] info, String[] query) {
        Applicant[] applicants = Arrays.stream(info)
                .map(Applicant::new)
                .toArray(Applicant[]::new);

        return Arrays.stream(query)
                .mapToInt(condition -> findPassPeople(condition, applicants))
                .toArray();
    }

    private int findPassPeople(String condition, Applicant[] applicants) {
        String[] conditions = Arrays.stream(condition.split(" "))
                .map(String::trim)
                .filter(letter -> !letter.equals("and"))
                .toArray(String[]::new);

        String wantedLanguage = conditions[0];
        String wantedPosition = conditions[1];
        String wantedCareer = conditions[2];
        String wantedSoulFood = conditions[3];
        int wantedScore = Integer.parseInt(conditions[4]);

        Arrays.sort(applicants);

        // 이진 탐색을 위한 시작점과 끝점 설정

        int start = 0;
        int end = applicants.length;
        // 이진 탐색 수행 (반복적)
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (applicants[mid].getScore() < wantedScore) {
                start = mid + 1;
                continue;
            }

            if (applicants[mid].getScore() >= wantedScore) { // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
                result = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
                end = mid - 1;
            }
        }

        System.out.println(result);
        Applicant[] subApplicants = Arrays.copyOfRange(applicants, result, applicants.length);

        return (int) Arrays.stream(subApplicants)
                .filter(applicant -> applicant.isEqualToLanguage(wantedLanguage))
                .filter(applicant -> applicant.isEqualToPosition(wantedPosition))
                .filter(applicant -> applicant.isEqualToCareer(wantedCareer))
                .filter(applicant -> applicant.isEqualToSoulFood(wantedSoulFood))
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

        public String getLanguage() {
            return language;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(Applicant o) {
            if (score < o.score) {
                return -1;
            }

            return 1;
        }
    }
}
