import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        int sum2 = IntStream.iterate(1, i -> i + 1)
                .limit(10)
                .reduce(10, (a, b) -> a + b); // 덧셈의 초기 값!

        int sum3 = IntStream.iterate(1, i -> i + 1)
                .limit(10)
//                .reduce(0, (a,b) -> a * b);  <- 이런 식으로하면 초깃값이 0이기 때문에 무조건 0 나온다!
                .reduce((a,b) -> a * b)
                .getAsInt();


        System.out.println(sum2);
        System.out.println(sum3);

    }
}
