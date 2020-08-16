package woo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public int[] solution(String[] history) {
        Stock stock = new Stock();

        Arrays.stream(history)
                .mapToDouble(Double::new)
                .forEach(manMinute -> stock.cookFood(manMinute));

        return stock.getPurchasingMoneys();
    }

    public class Stock {
        private static final int NEED_PIG_FOOT_FOR_FOOD = 4;
        private static final int PIG_FOOT_PRICE = 10000;
        private static final int PIG_FOOT_WEIGHT = 10;

        private static final int NEED_ONION_FOR_FOOD = 50;
        private static final int ONION_PRICE = 3000;
        private static final int ONION_WEIGHT = 100;

        private static final int NEED_WELSH_ONION_FOR_FOOD = 10;
        private static final int WELSH_ONION_PRICE = 1000;
        private static final int WELSH_ONION_LENGTH = 30;

        private static final int NEED_GALIC_FOR_FOOD = 10;
        private static final int GALIC_PRICE = 2000;
        private static final int GALIC_WEIGHT = 50;

        private static final int NEED_CHILI_FOR_FOOD = 4;
        private static final int CHILI_PRICE = 1000;
        private static final int CHILI_WEIGHT = 10;

        public static final double MAN_MINUTE = 1.0;

        public static final int ERROR_VALUE = -1;

        private int pigFoot = 5;
        private int onion = 100;
        private int welshOnion = 10;
        private int gallic = 5;
        private int chili = 2; // 칠리 주의할 것!

        private List<Integer> purchasingMoneys = new ArrayList<>();
        private int purchasingMoney = 0;

        public void cookFood(double manMinute) {
            double joonGirlFriendsManMinute = manMinute % MAN_MINUTE;
            double joon = manMinute - joonGirlFriendsManMinute;

            if (manMinute < 1.0 || (joonGirlFriendsManMinute != 0.5 && joonGirlFriendsManMinute != 0.0)
                    || (joon != 1.0 && joon != 2.0)) {
                purchasingMoneys.add(-1);
                return;
            }


            purchasingMoney = 0;
            if (joonGirlFriendsManMinute != 0.0) userIngredient(joonGirlFriendsManMinute);
            userIngredient(joon);
            purchasingMoneys.add(purchasingMoney);
        }

        public int[] getPurchasingMoneys() {
            return purchasingMoneys.contains(ERROR_VALUE) ? new int[]{-1} : purchasingMoneys.stream()
                    .mapToInt(Integer::new)
                    .toArray();
        }

        // 족발 레시피
        // 돼지 족 : 4 kg, 양파 : 50g, 대파 10cm, 마늘 10g, 고추 4g
        public void userIngredient(double manMinute) {
            usePigFoot(manMinute);
            useOnion(manMinute);
            useWelshOnion(manMinute);
            useGallic(manMinute);
            useChili(manMinute);
        }

        private void useChili(double manMinute) {
            int needChili = (int) (NEED_CHILI_FOR_FOOD * manMinute);
            if (manMinute == 0.0 || manMinute == 0.5) {
                needChili /= 2; // 준의 애인(0.0, 0.5인분)이면 고추를 절반 넣는다.
            }

            if (chili >= needChili) {
                chili -= needChili;
                return;
            }

            while (chili < needChili) {
                chili += CHILI_WEIGHT;
                purchasingMoney += CHILI_PRICE;
            }
            chili -= needChili;
        }

        private void useGallic(double manMinute) {
            int needGallic = (int) (NEED_GALIC_FOR_FOOD * manMinute);
            if (gallic >= needGallic) {
                gallic -= needGallic;
                return;
            }

            while (gallic < needGallic) {
                gallic += GALIC_WEIGHT;
                purchasingMoney += GALIC_PRICE;
            }
            gallic -= needGallic;
        }


        private void useOnion(double manMinute) {
            int needOnion = (int) (NEED_ONION_FOR_FOOD * manMinute);
            if (onion >= needOnion) {
                onion -= needOnion;
                return;
            }

            while (onion < needOnion) {
                onion += ONION_WEIGHT;
                purchasingMoney += ONION_PRICE;
            }
            onion -= needOnion;
        }

        private void useWelshOnion(double manMinute) {
            int needWelshOnion = (int) (NEED_WELSH_ONION_FOR_FOOD * manMinute);
            if (welshOnion >= needWelshOnion) {
                welshOnion -= needWelshOnion;
                return;
            }

            while (welshOnion < needWelshOnion) {
                welshOnion += WELSH_ONION_LENGTH;
                purchasingMoney += WELSH_ONION_PRICE;
            }
            welshOnion -= needWelshOnion;
        }

        private void usePigFoot(double manMinute) {
            int needPigFoot = (int) (NEED_PIG_FOOT_FOR_FOOD * manMinute);
            if (pigFoot >= needPigFoot) { // 재료료 충분하면 재료 소진
                pigFoot -= needPigFoot;
                return;
            }

            while (pigFoot < needPigFoot) { // 재료 부족하면 필요한만큼 구입!
                pigFoot += PIG_FOOT_WEIGHT;
                purchasingMoney += PIG_FOOT_PRICE;
            }
            pigFoot -= needPigFoot;
        }
    }
}
