package wootech3rd;

import java.util.ArrayList;
import java.util.List;

public class WooProblem5 {
    public String solution(String penter, String pexit, String pescape, String data) {
        int penterLength = penter.length();

        List<String> datas = new ArrayList<>();
        for (int i = 0; i < data.length(); i += penterLength) {
            datas.add(data.substring(i, i + penterLength));
        }

        System.out.println(datas);

        StringBuilder sb = new StringBuilder();
        sb.append(penter);
        for (String eachData : datas) {
            if (eachData.equals(penter) || eachData.equals(pexit) || eachData.equals(pescape)) {
                sb.append(pescape);
            }

            sb.append(eachData);
        }

        sb.append(pexit);

        return sb.toString();
    }
}
