package ebay2020;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EbayProblem3 {

    private int n;
    private long answer;

    public long solution(int n, int[][] products) {
        answer = 0;

        this.n = n;

        List<Goods> goods = Arrays.stream(products)
                .map(Goods::new)
                .sorted()
                .collect(Collectors.toList());

        int length = products.length;
        for (int i = 0; i < length; i++) {
            dfs(goods, i, 0, 0);
        }
        return answer;
    }

    private void dfs(List<Goods> goods, int i, int tryNum, int sum) {
        if (i < 0 || i >= goods.size()) {
            return;
        }

        if (tryNum == n) {
            System.out.println(sum);
            answer = answer < sum ? sum : answer;
            return;
        }

        List<Goods> cloneList = getCloneList(goods);
        cloneList.get(i).setSellPlace();
        int sellPrice = cloneList.stream()
                .mapToInt(Goods::getSellPrice)
                .sum();
        cloneList.get(i).cancelSellPlace();

        dfs(getCloneList(cloneList), i, tryNum + 1, sum + sellPrice);
        dfs(getCloneList(cloneList), i + 1, tryNum + 1, sum + sellPrice);
    }

    private List<Goods> getCloneList(List<Goods> products) {
        return products.stream()
                .map(Goods::getNew)
                .collect(Collectors.toList());
    }

    public class Goods {
        private Integer stock;
        private final Integer price;
        private Integer todaySellNumber;

        public Goods(int[] info) {
            this.stock = new Integer(info[0]);
            this.price = new Integer(info[1]);
            this.todaySellNumber = new Integer(info[2]);
        }

        public void setSellPlace() { //매대에 올린다.
            this.todaySellNumber *= 2;
        }

        public void cancelSellPlace() { //매대에 뺀다
            this.todaySellNumber /= 2;
        }

        public int getSellPrice() {
            if (stock >= todaySellNumber) {
                sellPrice();
                return todaySellNumber * price;
            }

            int restStock = stock - todaySellNumber;
            stock = 0;
            if (restStock > 0) {
                return restStock * price;
            }
            return 0;
        }

        private void sellPrice() {
            stock -= todaySellNumber;
        }

        public Goods getNew() {
            return new Goods(new int[]{stock, price, todaySellNumber});
        }
    }
}
