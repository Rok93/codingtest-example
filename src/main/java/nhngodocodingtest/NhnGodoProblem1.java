package nhngodocodingtest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NhnGodoProblem1 {
    // 한 번에 50달러 이상 지출하면, 10달러를 할인해주는 행사
    public int solution(int[] goods) {
        int eachPayGoodsPriceSum = Arrays.stream(goods)
                .filter(price -> price >= 50)
                .map(price -> price - 10)
                .sum(); // 50달러가 넘는 상품들 먼저 각각 10달러를 할인한 가격으로 더한 값

        List<Integer> restOfGoods = Arrays.stream(goods) // 남은 상품들을 오른차순으로 정렬
                .filter(price -> price < 50)
                .sorted()
                .mapToObj(Integer::new)
                .collect(Collectors.toList());

        System.out.println(restOfGoods);

        int l = 0;
        int r = restOfGoods.size() - 1;

        int sum = 0;
        while (l < r) { // 이분탐색의 아이디어를 떠올려서 적용!
            int currentSum = restOfGoods.get(l) + restOfGoods.get(r); // 가장작은값 + 가장 큰 값(조건에따라 작은값으로 이동)
            if (currentSum >= 50) {
                sum += (currentSum - 10);
                restOfGoods.remove(r--);
                restOfGoods.remove(l--);
            }

            // currentSum < 50 인 경우!
            l++;
        }

        int restGoodsPrice = restOfGoods.stream()
                .mapToInt(Integer::intValue)
                .sum();

        return eachPayGoodsPriceSum + sum + restGoodsPrice;
    }
}
