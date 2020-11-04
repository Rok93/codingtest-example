package wootech2nd20201101;

public class Problem5 { //todo: 5번 풀기!
    public int[] solution(String[] history) {
        int[] answer = new int[history.length];
        int cnt = 0;
        Stock stock = new Stock();
        for (String log : history) {
            double persons = Double.parseDouble(log);
            if (persons < 1.0 || persons > 2.5 || persons % 0.5 != 0) {
                return new int[]{-1};
            }

            answer[cnt++] = stock.needMoneyForCookJokbal(persons);
        }

        return answer;
    }

    public class Stock {
        private static final int RECIPE_PIG_FOOT = 4; // 돼지족 4kg
        private static final int RECIPE_ONION = 50; // 양파 50g
        private static final int RECIPE_LARGE_GREEN_ONION = 10; // 대파 10cm
        private static final int RECIPE_GALLIC = 10; //마늘 10g
        private static final int RECIPE_PEPPER = 4; // 고추 2g
        private static final int PURCHASING_PIG_FOOT_MONEY = 10000;
        private static final int PURCHASING_PIG_FOOT_AMOUNT = 10; // 10kg 당 10,000원
        private static final int PURCHASING_ONION_MONEY = 3000;
        private static final int PURCHASING_ONION_AMOUNT = 100; // 100g 3,000원
        private static final int PURCHASING_LARGE_GREEN_ONION_MONEY = 1000;
        private static final int PURCHASING_LARGE_GREEN_ONION_AMOUNT = 30; // 대파 30cm 1,000원
        private static final int PURCHASING_GALLIC_MONEY = 2000;
        private static final int PURCHASING_GALLIC_AMOUNT = 50; //50g 2,000원
        private static final int PURCHASING_PEPPER_MONEY = 1000;
        private static final int PURCHASING_PEPPER_AMOUNT = 10;

        private int pigFoot = 5;
        private int onion = 100;
        private int largeGreenOnion = 10;
        private int gallic = 5;
        private int pepper = 2;

        public int needMoneyForCookJokbal(double persons) {
            int needMoney = 0;

            if (persons % 1.0 != 0) { // 준의 애인도 먹는다!
                needMoney += useHalfPepper(persons);
            } else {
                needMoney += usePepper(persons);
            }

            needMoney += usePigFoot(persons);
            needMoney += useOnion(persons);
            needMoney += useLargeGreenOnion(persons);
            needMoney += useGallic(persons);
//            needMoney += usePepper(persons);

            System.out.println(toString()); // 족발 + 1

            return needMoney;
        }

        private int usePigFoot(double persons) {
            int needMoney = 0;
            while (pigFoot < RECIPE_PIG_FOOT * persons) {
                System.out.println("돼지 족 구매! " + PURCHASING_PIG_FOOT_MONEY + "원");
                needMoney += PURCHASING_PIG_FOOT_MONEY;
                pigFoot += PURCHASING_PIG_FOOT_AMOUNT;
            }

            pigFoot -= RECIPE_PIG_FOOT * persons;
            return needMoney;
        }

        private int useOnion(double persons) {
            int needMoney = 0;
            while (onion < RECIPE_ONION * persons) {
                System.out.println("양파 구매!" + PURCHASING_ONION_MONEY + "원");
                needMoney += PURCHASING_ONION_MONEY;
                onion += PURCHASING_ONION_AMOUNT;
            }

            onion -= RECIPE_ONION * persons;
            return needMoney;
        }

        private int useLargeGreenOnion(double persons) {
            int needMoney = 0;
            while (largeGreenOnion < RECIPE_LARGE_GREEN_ONION * persons) {
                System.out.println("대파 구매 " + PURCHASING_LARGE_GREEN_ONION_MONEY + "원 ");
                needMoney += PURCHASING_LARGE_GREEN_ONION_MONEY;
                largeGreenOnion += PURCHASING_LARGE_GREEN_ONION_AMOUNT;
            }

            largeGreenOnion -= RECIPE_LARGE_GREEN_ONION * persons;
            return needMoney;
        }


        private int useGallic(double persons) {
            int needMoney = 0;
            while (gallic < RECIPE_GALLIC * persons) {
                System.out.println("마늘  구매! " + PURCHASING_GALLIC_MONEY + "원 ");
                needMoney += PURCHASING_GALLIC_MONEY;
                gallic += PURCHASING_GALLIC_AMOUNT;
            }

            gallic -= RECIPE_GALLIC * persons;
            return needMoney;
        }

        private int usePepper(double persons) {
            int needMoney = 0;
            while (pepper < RECIPE_PEPPER * persons) {
                System.out.println("고추 구매! "  + PURCHASING_PEPPER_MONEY + "원 ");
                needMoney += PURCHASING_PEPPER_MONEY;
                pepper += PURCHASING_PEPPER_AMOUNT;
            }

            pepper -= RECIPE_PEPPER * persons;
            return needMoney;
        } // 대파 2번 + 고추 1번

        private int useHalfPepper(double persons) {
            int needMoney = 0;
            while (pepper < RECIPE_PEPPER * persons / 2) {
                System.out.println("고추 구매! (반 쓰다가) " + PURCHASING_PEPPER_MONEY + "원 ");
                needMoney += PURCHASING_PEPPER_MONEY;
                pepper += PURCHASING_PEPPER_AMOUNT;
            }

            pepper -= RECIPE_PEPPER * persons / 2;
            return needMoney;
        }

        @Override
        public String toString() {
            return "Stock{" +
                    "pigFoot=" + pigFoot +
                    ", onion=" + onion +
                    ", largeGreenOnion=" + largeGreenOnion +
                    ", gallic=" + gallic +
                    ", pepper=" + pepper +
                    '}';
        }
    }
}
