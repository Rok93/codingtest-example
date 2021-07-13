package temp;

public interface Born {
    public static final int AGE = 30;
    String HELLO = "hello";

    default void hi() {
        System.out.println(AGE);
    }
}
