package naver2021;

import java.util.ArrayList;
import java.util.List;

public class NaverProblem1 {
    public String solution(String m, String k) {
        // 2 <= m <= 10,000,000 이하인 문자열
        // 2 <= k <= 10,000 이하인 문자열
        // k < m (항상)
        // m, k는 소문자로만 구성됌

        String[] splitK = k.split("");
        String[] splitM = m.split("");
        int mLen = splitM.length;
        int kLen = splitK.length;
        int cnt = 0;
        List<Integer> removeIndexs = new ArrayList<>();
        for (int i = 0; i < mLen; i++) {
            if (splitK[cnt].equals(splitM[i])) {
                cnt++;
                removeIndexs.add(i);

                if (cnt == kLen) {
                    break;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mLen; i++) {
            if (removeIndexs.contains(i)) {
                continue;
            }

            sb.append(m.charAt(i));
        }

        // k는 m의 메시지 중간에 임의로 끼워넣음 !
        return sb.toString();
    }
}
