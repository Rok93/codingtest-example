package nhngodocodingtest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NhnGodoProblem1_2 {
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

        // 남은 굿즈의 개수가 1, 2, 3 인 경우의 수를 구해서 따로 계산한다.
        if (restOfGoods.size() == 1) { // 1개인 경우, 그 값을 바로 더하면 된다.
            return eachPayGoodsPriceSum + restOfGoods.get(0);
        }

        // 2개인 경우와 3개인 경우는 나머지 값을 더해서 50을 넘으면 할인을 적용하고, 넘지 않으면 더한값을 그대로 totalPrice에 더해준다.
        // (3개의 경우 49, 49, 49 인 경우를 생각했을 때, 최대 할인은 어짜피 1번밖에 적용이 안된다! 이점을 이용하면 2개인 경우와 동일하게 처리할 수 있다)
        int sum = restOfGoods.stream()
                .mapToInt(Integer::intValue)
                .sum();
        sum = sum >= 50 ? sum - 10 : sum;

        return eachPayGoodsPriceSum + sum;
    }
}
