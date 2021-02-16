package wootech3rd;

import java.util.*;
import java.util.stream.Collectors;

public class WooProblem6 {
    public String[] solution(String[] logs) {

        List<Tester> testers = new ArrayList<>();
        for (String log : logs) {
            String[] data = log.split(" ");
            String testNumber = data[0];
            int problemNumber = Integer.parseInt(data[1]);
            int problemScore = Integer.parseInt(data[2]);

            Tester tester = new Tester(testNumber);
            if (testers.contains(tester)) {
                for (Tester testerPeople : testers) {
                    if (testerPeople.equals(tester)) {
                        testerPeople.addScore(problemNumber, problemScore);
                        break;
                    }
                }

                continue;
            }
            tester.addScore(problemNumber, problemScore);
            testers.add(tester);
        }

        List<Tester> wrongdoers = new ArrayList<>();
        int testerNumber = testers.size();
        for (int i = 0; i < testerNumber - 1; i++) {
            for (int j = i + 1; j < testerNumber; j++) {
                if (isWrongDoers(testers.get(i), testers.get(j))) {
                    wrongdoers.add(testers.get(i));
                    wrongdoers.add(testers.get(j));
                }
            }
        }

        if (wrongdoers.size() == 0) {
            return new String[]{"None"};
        }

        String[] answer = wrongdoers.stream()
                .map(Tester::getTestNumber)
                .distinct()
                .sorted()
                .toArray(String[]::new);

        return answer;
    }

    private boolean isWrongDoers(Tester tester1, Tester tester2) {
        // 1. 두 수험자가 푼 문제 수가 같다. (단 푼 문제 수가 5 미만인 경우는 제외한다.)
        if (!isEqualToSolvedProblemNumber(tester1, tester2)) {
            return false;
        }

        // 2. 두 수험자가 푼 문제의 번호가 모두 같다.
        if (!isEqualToExactlySolvedSameProblem(tester1, tester2)) {
            return false;
        }

        // 3. 두 수험자가 푼 문제의 점수가 모두 같다. (고민해야하는 부분인듯!)
        if (!isEqualToExactlySolvedSameProblemScore(tester1, tester2)) {
            return false;
        }
        // 임의의 두 수험자가 위 3가지 조건에 모두 부합하는 경우, 두 수험자를 부정행위자로 의심한다.

        return true;
    }

    private boolean isEqualToExactlySolvedSameProblemScore(Tester tester1, Tester tester2) {
        List<Integer> solvedProblems = tester1.getScores().entrySet().stream()
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        Map<Integer, Integer> test1Scores = tester1.getScores();
        Map<Integer, Integer> test2Scores = tester2.getScores();

        int size = solvedProblems.size();
        for (int i = 0; i < size; i++) {
            Integer targetScore = new Integer(solvedProblems.get(i));
            if (!test1Scores.get(targetScore).equals(test2Scores.get(new Integer(targetScore)))) {
                return false;
            }
        }

        return true;
    }

    private boolean isEqualToExactlySolvedSameProblem(Tester tester1, Tester tester2) {
        List<Integer> tester1SolvedProblems = tester1.getScores().entrySet().stream()
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> tester2SolvedProblems = tester2.getScores().entrySet().stream()
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        int length = tester1SolvedProblems.size();
        for (int i = 0; i < length; i++) {
            if (!tester1SolvedProblems.get(i).equals(tester2SolvedProblems.get(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean isEqualToSolvedProblemNumber(Tester tester1, Tester tester2) {
        if (tester1.getScores().size() < 5 || tester2.getScores().size() < 5) {
            return false;
        }

        return tester1.getScores().size() == tester2.getScores().size();
    }

    public class Tester {
        private final String testNumber;
        private Map<Integer, Integer> scores;

        public Tester(String testNumber) {
            this.testNumber = testNumber;
            scores = new HashMap<>();
        }

        public void addScore(int problemNumber, int problemScore) {
            scores.put(problemNumber, problemScore);
        }

        public String getTestNumber() {
            return testNumber;
        }

        public Map<Integer, Integer> getScores() {
            return scores;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tester tester = (Tester) o;
            return testNumber.equals(tester.testNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(testNumber, scores);
        }
    }
}
