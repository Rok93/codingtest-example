package practice.kakao2021.intern;

import java.util.Arrays;

public class Problem3 {
    private String[] user_id;
    private String[] banned_id;
    int cnt = 0;

    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;

        int userNumber = user_id.length;
        int banNumber = banned_id.length;

        String[] comArr = new String[banNumber];
        combination(comArr, userNumber, banNumber, 0, 0);


        int[] aa = Arrays.stream(banned_id)
                .mapToInt(banId -> (int) Arrays.stream(user_id)
                        .filter(userId -> isMatchId(userId, banId))
                        .count())// 이부분꺼 만들기
                .toArray();

        return cnt;
    }

    private boolean isMatchId(String userId, String banId) {
        if (userId.length() != banId.length()) {
            return false;
        }

        char[] userIds = userId.toCharArray();
        char[] banIds = banId.toCharArray();

        int userIdLength = userIds.length;
        for (int i = 0; i < userIdLength; i++) {
            if (banIds[i] == '*' || banIds[i] == userIds[i]) {
                continue;
            }
            return false;
        }
        return true;
    }

    private void countCnt(String[] comArr) {
        int len = comArr.length;

        for (int i = 0; i < len; i++) {
            if (isMatchId(comArr[i], banned_id[i])) {
                if (i == len - 1) {
                    cnt++;
                    break;
                }
            }
            break;
        }

        for (int i = 0; i < len; i++) {
            if (isMatchId(comArr[i], banned_id[len - 1 - i])) {
                if (i == len - 1) {
                    cnt++;
                    break;
                }
            }
            break;
        }
    }

    //조합 (순서관심없고 뽑은 유무만 생각)
    private void combination(String[] comArr, int n, int r, int index, int target) {
        if (r == 0) {
            countCnt(comArr);
            return;
        }
        if (target == n) return;

        comArr[index] = this.user_id[target];
        combination(comArr, n, r - 1, index + 1, target + 1);//뽑는경우
        combination(comArr, n, r, index, target + 1);//안뽑는경우
    }
}
