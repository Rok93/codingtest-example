package wootech2nd20201101;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem3 {
    public int solution(int[] prices, int[] discounts) {
        List<Integer> pricesList = Arrays.stream(prices)
                .mapToObj(Integer::new)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(pricesList);

        List<Integer> discountsList = Arrays.stream(discounts)
                .mapToObj(Integer::new)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(discountsList);

        int sum = 0;
        int size = discountsList.size();
        for (int i = 0; i < size; i++) {
            sum += pricesList.get(i) * (100 -discountsList.get(i)) / 100;
        }

        int priceSize = pricesList.size();
        for (int i = size; i < priceSize; i++) {
            sum += pricesList.get(i);
        }

        return sum;
    }
}
