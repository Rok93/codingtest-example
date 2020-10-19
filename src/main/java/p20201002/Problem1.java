package p20201002;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println("hello");
        int score = 3;

        String hello_ = hello("hello ", score);
        System.out.println(hello_);
    }

    private static String hello(String content, int score) {
        return content + score;
    }

}
