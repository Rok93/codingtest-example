package p20201030;


import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    public static void main(String[] args) {
    }

    public static class Kiosk {
        private final int number;
        private final Queue<Customer> customers;

        public Kiosk(int number) {
            this.number = number;
            customers = new LinkedList<>();
        }
    }

    public static class Customer {
        private final String name;

        public Customer(String name) {
            this.name = name;
        }
    }
}
