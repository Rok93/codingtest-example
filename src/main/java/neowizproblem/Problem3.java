package neowizproblem;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem3 {
    public int solution(int[] p) {
        Map<Integer, Long> map = Arrays.stream(p)
                .mapToObj(Integer::new)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int cnt = 0;
        while (map.size() > 0) {
            cnt += (map.size() - 1);
            removeZeroValues(map);
        }
        return cnt;
    }

    private void removeZeroValues(Map<Integer, Long> map) {

        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            if (map.get(key).equals(1L)) {
                it.remove();
                continue;
            }
            map.put(key, (map.get(key) - 1L));
        }
    }
}
