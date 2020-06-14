package p20200606;

import java.util.ArrayList;
import java.util.List;

public class Study3 {
    private String[] buttons;
    private int[] scores;

    public int solution(String command, String[] buttons, int[] scores) {
        this.buttons = buttons;
        this.scores = scores;

        return getMaxScore(command);
    }

    private int getMaxScore(String command) {
        List<String> buttonList = new ArrayList<>();
        List<Integer> scoreList = new ArrayList<>();

        int len = buttons.length;
        for (int i = 0; i < len; i++) {
            if (buttons[i].length() < scores[i]) { //점수 가성비가 없음
                buttonList.add(buttons[i]);
                scoreList.add(scores[i]);
            }
        }


        int score = command.length();
        int buttonListSize = buttonList.size();
        int cnt = 0;
        while (cnt < buttonListSize) {
            String copyCommand = command;

            int tempScore = 0;
            for (int i = 0; i < buttonListSize; i++) {
                String currentButton = buttonList.get(i);
                if (copyCommand.contains(currentButton)) {
                    int beforeLen = copyCommand.length();
                    copyCommand = copyCommand.replace(currentButton, "");
                    int afterLen = copyCommand.length();
                    int count = (beforeLen - afterLen) / currentButton.length();

                    tempScore += scoreList.get(i) * count;
                }
            }
            tempScore += copyCommand.length(); //나머지 버튼들

            score = score < tempScore ? tempScore : score;

            swap(buttonList, scoreList); //순서 변경
            cnt++;
        }

        return score;
    }

    private void swap(List<String> buttonList, List<Integer> scoreList) {
        String tempButton = buttonList.get(0);
        int tempScore = scoreList.get(0);

        buttonList.remove(0);
        scoreList.remove(0);

        buttonList.add(tempButton);
        scoreList.add(tempScore);
    }
}
