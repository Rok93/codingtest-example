package p20200823.socar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SocarProblem3 {
    private int timeLimit;
    private List<Integer> tips;
    private House[][] houses;
    private boolean[][] visited;
    private int r;

    public int solution(int r, int[][] delivery) { // (배달 제한 시간, 배달 팁)
        houses = new House[r][r];
        visited = new boolean[r][r];
        this.r = r;

        timeLimit = Arrays.stream(delivery)
                .mapToInt(a -> a[0])
                .max()
                .getAsInt();

        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                houses[i][j] = new House(delivery[cnt++]);
            }
        }

        tips = new ArrayList<>();

        startDelivery(0, 0, r, 0);

        return tips.stream()
                .mapToInt(Integer::new)
                .max()
                .getAsInt();
    }

    private void startDelivery(int x, int y, int currentTime, int sum) {
        if (x < 0 || x >= r || y < 0 || y >= r) {
            return;
        }

        if (currentTime > timeLimit) {
            tips.add(sum);
        }

        House currentHouse = houses[x][y];

        if (!currentHouse.overTimeLimit(currentTime) || currentHouse.isVisited()) {
            sum += currentHouse.payTip();
            currentHouse.visit();
        }

        int rightHousePay = -1;
        if (y + 1 < r) {
            rightHousePay = houses[x][y + 1].getTip();
        }

        int belowHousePay = -1;
        if (x + 1 < r) {
            belowHousePay = houses[x + 1][y].getTip();
        }

        if (rightHousePay >= belowHousePay) {
            startDelivery(x, y + 1, currentTime + 1, sum);
        } else {
            startDelivery(x + 1, y, currentTime + 1, sum);
        }
    }

    public class House {
        private final int limitTime;
        private final int tip;
        private boolean visited = false;

        public House(int[] eachDelivery) {
            this.limitTime = eachDelivery[0];
            this.tip = eachDelivery[1];
        }

        public int getTip() {
            return tip;
        }

        public int payTip() {
            int pay = tip;
            return pay;
        }

        public void visit() {
            visited = true;
        }

        public boolean isVisited() {
            return visited;
        }

        public boolean overTimeLimit(int currentTime) {
            return limitTime >= currentTime;
        }
    }
}
