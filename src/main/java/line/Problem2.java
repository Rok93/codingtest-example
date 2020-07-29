package line;

public class Problem2 {
    public int solution(String answer_sheet, String[] sheets) {
        int answer = 0;

        for (int i = 0; i < sheets.length - 1; i++) {
            for (int j = i + 1; j < sheets.length; j++) {
                int cheatingValue = getCheatingValue(sheets[i], sheets[j], answer_sheet);
                answer = Math.max(answer, cheatingValue);
            }
        }
        return answer;
    }

    private int getCheatingValue(String sheet1, String sheet2, String answer_sheet) {
        // 총 의심문항(오답 + 같은 선택지) 갯수
        String[] sheets1 = sheet1.split("");
        String[] sheets2 = sheet2.split("");

        int totalNumberOfDoubtfulProblem = 0; // 총 의심문항 갯수
        int lengthOfLogestDoubtfulProblem = 0; // 가장 긴 연속된 의심문항의 수

        int tempLength = 0;
        for (int i = 0; i < answer_sheet.length(); i++) {
            if (isDoubtful(sheets1[i], sheets2[i], answer_sheet.split("")[i])) {
                totalNumberOfDoubtfulProblem++;
                tempLength++;

                if (i == answer_sheet.length() - 1) {
                    lengthOfLogestDoubtfulProblem = Math.max(lengthOfLogestDoubtfulProblem, tempLength);
                }
            } else {
                lengthOfLogestDoubtfulProblem = Math.max(lengthOfLogestDoubtfulProblem, tempLength);
                tempLength = 0;
            }
        }

        return totalNumberOfDoubtfulProblem + lengthOfLogestDoubtfulProblem * lengthOfLogestDoubtfulProblem;

        // 가장 긴 연속된 의심문항의 수
    }

    private boolean isDoubtful(String s1, String s2, String a) {
        if (!a.equals(s1) && !a.equals(s2)) { // 둘다 오답이고,
            // 같은 선택지
            return s1.equals(s2); // 의심스럽다
        }
        return false;
    }

    public static void main(String[] args) {
        Problem2 sol = new Problem2();
        String answer_sheet1 = "4132315142";
        String[] sheets1 = {"3241523133", "4121314445", "3243523133", "4433325251", "2412313253"};
//        System.out.println(sol.solution(answer_sheet1, sheets1));

        String answer_sheet2 = "53241";
        String[] sheets2 = {"53241", "42133", "53241", "14354"};
//        System.out.println(sol.solution(answer_sheet2, sheets2));


        String answer_sheet3 = "24551";
        String[] sheets3 = {"24553", "24553", "24553", "24553"};
        System.out.println(sol.solution(answer_sheet3, sheets3));
    }
}
