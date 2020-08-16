package woo2;

class Stock {
    private int porkFeet;
    private int onion;
    private int greenOnion;
    private int garlic;
    private int pepper;

    public int getPorkFeet() {
        return porkFeet;
    }

    public int getOnion() {
        return onion;
    }

    public int getGreenOnion() {
        return greenOnion;
    }

    public int getGarlic() {
        return garlic;
    }

    public int getPepper() {
        return pepper;
    }

    public void setPorkFeet(int porkFeet) {
        this.porkFeet = porkFeet;
    }

    public void setOnion(int onion) {
        this.onion = onion;
    }

    public void setGreenOnion(int greenOnion) {
        this.greenOnion = greenOnion;
    }

    public void setGarlic(int garlic) {
        this.garlic = garlic;
    }

    public void setPepper(int pepper) {
        this.pepper = pepper;
    }
}

public class Woo5 {
    //  재고가 레시피보다 적을때 구매, 재고 추가

    public int[] solution(String[] history) {

        int[] answer = {};
        Stock stock = new Stock();
        stock.setPorkFeet(5);
        stock.setOnion(100);
        stock.setGreenOnion(10);
        stock.setGarlic(5);
        stock.setPepper(2);

        boolean check = false;
        answer = new int[history.length];
        for (int i = 0; i < history.length; i++) {
            if (history[i].split("\\.")[0].equals("1") || history[i].split("\\.")[0].equals("2")) {
                check = true;
            } else {
                check = false;
                answer = new int[] {-1};
                break;
            }
            if (history[i].split("\\.")[1].equals("0") || history[i].split("\\.")[1].equals("5")) {
                check = true;
            } else {
                check = false;
                answer = new int[] {-1};
                break;
            }
            int amount = 0;
            double eat = Double.parseDouble(history[i]);
            if (stock.getPorkFeet() < 4 * eat) {
                amount = amount + 10000;
                stock.setPorkFeet(stock.getPorkFeet() + 10 - (int)(4 * eat));
            } else {
                stock.setPorkFeet(stock.getPorkFeet() - (int)(4 * eat));
            }
            if (stock.getOnion() < 50 * eat) {
                amount = amount + 3000;
                stock.setOnion(stock.getOnion() + 100 - (int)(50 * eat));
            } else {
                stock.setOnion(stock.getOnion() - (int)(50 * eat));
            }
            if (stock.getGreenOnion() < 10 * eat) {
                amount = amount + 1000;
                stock.setGreenOnion(stock.getGreenOnion() + 30 - (int)(10 * eat));
            } else {
                stock.setGreenOnion(stock.getGreenOnion() - (int)(10 * eat));
            }
            if (stock.getGarlic() < 10 * eat) {
                amount = amount + 2000;
                stock.setGarlic(stock.getGarlic() + 50 - (int)(10 * eat));
            } else {
                stock.setGarlic(stock.getGarlic() - (int)(10 * eat));
            }
            if (history[i].split("\\.")[1].equals("0")) {
                if (stock.getPepper() < 4 * eat) {
                    amount = amount + 1000;
                    stock.setPepper((stock.getPepper() + 10 - (int)(4 * eat)));
                } else {
                    stock.setPepper((stock.getPepper() - (int)(4 * eat)));
                }
            } else {
                if (stock.getPepper() < 2 * eat) {
                    amount = amount + 1000;
                    stock.setPepper((stock.getPepper() + 10 - (int)(2 * eat)));
                } else {
                    stock.setPepper((stock.getPepper() - (int)(2 * eat)));
                }
            }

            answer[i] = amount;
            check = true;
        }

        if (check) {
            return answer;
        } else {
            return new int[] {-1};
        }

    }

    public static void main(String[] args) {
        Woo5 woo5 = new Woo5();
        String[] history = {"1.0", "1.0", "2.0", "2.0", "1.0", "1.0", "2.0", "2.0", "1.0", "2.0", "2.0", "2.0", "1.0",
                "2.0", "2.0", "1.0", "1.0", "1.0", "2.0", "2.0", "1.0", "2.0", "1.0", "2.0"};
        int[] array = new int[history.length];
        array = woo5.solution(history);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
