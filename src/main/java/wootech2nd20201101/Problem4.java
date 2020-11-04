package wootech2nd20201101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    private String loginUser = "";
    private String[] infos;

    public boolean[] solution(String[] infos, String[] actions) {
        List<String> wishList = new ArrayList<>();
        this.infos = infos;
        boolean[] answer = new boolean[actions.length];
        int cnt = 0;

        for (String action : actions) {
            String[] actionDatas = action.split(" ");

            if (actionDatas[0].equals("ADD")) {
                if (loginUser.isEmpty()) {
                    answer[cnt++] = false;
                    continue;
                }

                wishList.add(actionDatas[1]);
                answer[cnt++] = true;
                continue;
            }

            if (actionDatas[0].equals("LOGIN")) {
                if (loginUser.isEmpty() && isCorrectUserAndPassword(actionDatas[1], actionDatas[2])) {
                    loginUser = actionDatas[1];
                    answer[cnt++] = true;
                    continue;
                }

                answer[cnt++] = false;
                continue;
            }

            if (actionDatas[0].equals("ORDER")) {
                if (loginUser.isEmpty()) {
                    answer[cnt++] = false;
                    continue;
                }

                if (wishList.isEmpty()) {
                    answer[cnt++] = false;
                    continue;
                }

                answer[cnt++] = true;
                wishList.clear();
            }
        }

        return answer;
    }

    private boolean isCorrectUserAndPassword(String id, String password) {
        return Arrays.stream(infos)
                .anyMatch(info -> isMatchIdAndPassword(info, id, password));
    }

    private boolean isMatchIdAndPassword(String info, String id, String password) {
        String[] userInfo = info.split(" ");
        return id.equals(userInfo[0]) && password.equals(userInfo[1]);
    }
}
