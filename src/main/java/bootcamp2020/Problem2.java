package bootcamp2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public int[] solution(int[] arrayA, int[] arrayB) {
        Set setA = new Set(arrayA);
        Set setB = new Set(arrayB);
        Set sumAB = sum(setA, setB);
        Set complementAB = complement(setA, setB);
        Set intersect = intersect(setA, setB);

        return new int[]{setA.getSize(), setB.getSize(), sumAB.getSize(), complementAB.getSize(), intersect.getSize()};
    }

    public Set sum(Set base, Set other) { // 두 원소들을 더해서 합집합을 리턴!
        List<Integer> otherList = other.getList();
        List<Integer> baseList = base.getList();

        for (Integer i : otherList) {
            if (baseList.contains(i)) {
                continue;
            }
            baseList.add(i);
        }

        return new Set(baseList.stream()
                .mapToInt(Integer::intValue)
                .toArray());
    }

    public Set complement(Set base, Set other) { // base에서 other 원소 빼서 차집합
        List<Integer> otherList = other.getList();
        List<Integer> baseList = base.getList();
        return new Set(baseList.stream()
                .filter(number -> !otherList.contains(number))
                .mapToInt(Integer::intValue)
                .toArray());
    }

    public Set intersect(Set base, Set other) { // 두 집합에 모두 있는 원소들만 리턴
        List<Integer> otherList = other.getList();
        List<Integer> baseList = base.getList();
        return new Set(baseList.stream()
                .filter(object -> otherList.contains(object))
                .mapToInt(Integer::intValue)
                .toArray());
    }

    public class Set {
        private List<Integer> list;

        public Set(int[] arr) {
            this.list = removeDuplication(arr);
        }

        private List<Integer> removeDuplication(int[] arr) {
            List<Integer> list = Arrays.stream(arr)
                    .mapToObj(Integer::new)
                    .collect(Collectors.toList());

            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).equals(list.get(j))) {
                        list.remove(j--);
                        continue;
                    }
                }
            }
            return list;
        }

        public List<Integer> getList() {
            return new ArrayList<>(list);
        }

        public int getSize() {
            return list.size();
        }
    }
}
