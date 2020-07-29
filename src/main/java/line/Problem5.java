package line;

import java.util.*;
import java.util.stream.Collectors;

public class Problem5 {
    public String[] solution(String[][] dataSource, String[] tags) {

        List<String> tagsList = Arrays.stream(tags)
                .collect(Collectors.toList());

        Map<String, Integer> matchingNumber = new HashMap<>();

        for (int i = 0; i < dataSource.length; i++) {
            int tagEqualNumber = (int) Arrays.stream(dataSource[i])
                    .filter(tagsList::contains)
                    .count();
            if (tagEqualNumber != 0) {
                matchingNumber.put(dataSource[i][0], tagEqualNumber);
            }
        }
        String[] answer;
        if (matchingNumber.size() < 10) {
            answer = new String[matchingNumber.size()];
        } else {
            answer = new String[10];
        }

        Iterator iterator = sortByValue(matchingNumber).iterator();
        int cnt = 0;
        while (iterator.hasNext()) {
            if (cnt >= 10) {
                break;
            }

            String temp = (String) iterator.next();
            answer[cnt++] = temp;
        }
        return answer;
    }

    //별도의 스태틱 함수로 구현

    private List sortByValue(final Map map) {

        List<String> list = new ArrayList();
        list.addAll(map.keySet());

        list.sort((Object o1, Object o2) -> {
            Object value1 = map.get(o1);
            Object value2 = map.get(o2);
            return ((Comparable) value1).compareTo(value2);
        });

        Collections.reverse(list); // 주석시 오름차순
        return list;
    }

    public static void main(String[] args) {
        Problem5 sol = new Problem5();

        String[][] dataSource = {
                {"doc1", "t1", "t2", "t3"},
                {"doc2", "t0", "t2", "t3"},
                {"doc3", "t1", "t6", "t7"},
                {"doc4", "t1", "t2", "t4"},
                {"doc5", "t6", "t100", "t8"}
        };

        String[] tags = {"t1", "t2", "t3"};
        String[] result = {"doc1", "doc2", "doc4", "doc3"};

        System.out.println(sol.solution(dataSource, tags));
    }
}
